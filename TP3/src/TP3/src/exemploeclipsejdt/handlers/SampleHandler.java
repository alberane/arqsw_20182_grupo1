package exemploeclipsejdt.handlers;

import java.awt.image.RasterFormatException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.BlockComment;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.core.dom.rewrite.ITrackedNodePosition;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.eclipse.jdt.internal.core.JavadocContents;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.text.edits.UndoEdit;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import org.eclipse.jface.*;
import org.eclipse.ui.handlers.HandlerUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import exemploeclipsejdt.ast.CyclomaticComplexityVisitor;
import exemploeclipsejdt.ast.LCOM;
import exemploeclipsejdt.ast.MethodVisitor;
import exemploeclipsejdt.ast.NumberOfAttributes;
import exemploeclipsejdt.ast.Refactor;
import exemploeclipsejdt.ast.SimpleASTVisitor;
import exemploeclipsejdt.ast.TestLCOM;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SampleHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public SampleHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information from
	 * the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		IWorkbenchPart workbenchPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActivePart();

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		// raiz
		IWorkspaceRoot root = workspace.getRoot();
		// pega todos projetos
		IProject[] projetos = root.getProjects();		

		/*
		 * IJavaProject: É o nó do modelo Java e representa um projeto Java. Ele contém
		 * IPackageFragmentRoots como nós filhos. IPackageFragmentRoot: pode ser uma
		 * fonte ou uma pasta de classe de um projeto, um .zipou um .jararquivo.
		 * IPackageFragmentRootpode conter arquivos binários ou de origem.
		 * IPackageFragment: Um único pacote. Ele contém ICompilationUnits ou
		 * IClassFiles, dependendo IPackageFragmentRootdo tipo de fonte ou do tipo
		 * binário. Observe que IPackageFragmentnão estão organizados como pai-filho.
		 * Por exemplo, net.sf.anão é o pai de net.sf.a.b. Eles são dois filhos
		 * independentes do mesmo IPackageFragmentRoot. ICompilationUnit: um arquivo de
		 * origem Java. IImportDeclaration, IType, IField, IInitializer, IMethod: Filhos
		 * de ICompilationUnit. As informações fornecidas por esses nós também estão
		 * disponíveis na AST.
		 */
		Refactor rf;
		for (IProject projeto : projetos) { 											// percorre todos projetos do eclipse
			try {
				if (projeto.isAccessible() & projeto.isOpen()) { 						// verifica se o projeto está acessível e aberto
					IJavaProject jprojeto = JavaCore.create(projeto);
					IPackageFragmentRoot[] pkgs = jprojeto.getPackageFragmentRoots(); 	// arquivos do projeto
					jprojeto.getAllPackageFragmentRoots();
					IPackageFragment[] teste = jprojeto.getPackageFragments(); 			// contém as classes java

					for (IPackageFragment fg : teste) { 								// percorre os arquivos java
						ICompilationUnit[] unit = fg.getCompilationUnits(); 			// cria um arquivo para ser analisado
																						// (ICompilationUnit contém todas
																						// informações da classe)
						for (ICompilationUnit un : unit) {
							ASTParser parser = ASTParser.newParser(AST.JLS10);
							parser.setKind(ASTParser.K_COMPILATION_UNIT);
							parser.setSource(un);
							parser.setResolveBindings(true);
							CompilationUnit classUnit = (CompilationUnit) parser.createAST(null);
							// initiazer modofied class
							classUnit.recordModifications();
							AST ast = classUnit.getAST();
							
							TestLCOM lcom = new TestLCOM(un);																
							
							JSONObject json = new JSONObject();
							JSONArray jsonAttributes = new JSONArray();
							Map<String, HashSet<String>> refatorClass = new HashMap<>();
							Map<String, HashSet<String>> copyRefatorClass = new HashMap<>();
							List<String> attributeExclusive = new ArrayList<>();
							refatorClass = lcom.getResult();
							copyRefatorClass = lcom.getResult();
							int count = 0, i = 0;						
							
							json.put("class", lcom.getClasse());
							
							
							for (Iterator<HashSet<String>> it = refatorClass.values().iterator(); it.hasNext();i++) { 
								Set<String> methods = it.next();								
								//HashSet<String> key = (HashSet<String>)it.next();
								//Set<Entry<String, HashSet<String>>> keys = refatorClass.entrySet();
								if (methods.size() == 1){    //use in one method									
									for (String m: methods) { 
										for (Iterator<HashSet<String>> itCopy = copyRefatorClass.values().iterator(); itCopy.hasNext();) {
											Set<String> methodsCopy = itCopy.next();
											if(methodsCopy.size()>1) {  //addEndereco, addPessoa
												count=0;
												/*for (String method: methodsCopy) {													
													if(method.equals(m)) {
														continue;
													}else {
														count++;
													}
												}*/
												if(!methodsCopy.contains(m)) {
													//attributeExclusive.add(m);
													count++;
												}
											}	
										}
										/*if (count==1) {
											attributeExclusive.add(m);
										}*/
										if (count>0) {
											if (!attributeExclusive.contains(m)){
												attributeExclusive.add(m);			
											}
											//json.put("method", m);											
										}
									}	
									
								}
							}
							
							//json.put("attributes", jsonAttributes);
							//System.out.println(attributeExclusive.toString());
							//System.out.println(json.toString());
							
							if (attributeExclusive.isEmpty()) {
								System.out.println("==================================================");
								System.out.println("PACOTE.CLASSE:"+lcom.getClasse());
								System.out.println("CLASSE ESTÁ COESA PARABÉNS!");
								System.out.println("==================================================");
							}else { 
								System.out.println("==================================================");
								System.out.println("SUGESTÃO DE ANALISE PARA REFATORAÇÃO DO PROJETO");
								System.out.println("PACOTE.CLASSE:"+lcom.getClasse());
								System.out.println("MÉTODOS COM ATRIBUTOS EXCLUSIVOS:"+attributeExclusive.toString());
								System.out.println("AVALIE A EXECUSÃO DE UM EXTRACT CLASS PARA MELHORAR A COESÃO!");
								System.out.println("==================================================");
							}
						}
					}

				}
			} catch (Exception e) {

			}

		}

		IFile file = (IFile) workbenchPart.getSite().getPage().getActiveEditor().getEditorInput()
				.getAdapter(IFile.class);
		if (file == null) {
			MessageDialog.openInformation(window.getShell(), "ExemploEclipseJDT", "Não existem arquivos abertos");
			return null;
		}

		final ICompilationUnit unit = ((ICompilationUnit) JavaCore.create(file));
		return null;

	}

}
