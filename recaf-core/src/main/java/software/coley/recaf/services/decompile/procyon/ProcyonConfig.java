package software.coley.recaf.services.decompile.procyon;

import com.strobel.assembler.metadata.CompilerTarget;
import com.strobel.decompiler.DecompilerSettings;
import com.strobel.decompiler.languages.BytecodeOutputOptions;
import com.strobel.decompiler.languages.Language;
import com.strobel.decompiler.languages.Languages;
import com.strobel.decompiler.languages.java.BraceEnforcement;
import com.strobel.decompiler.languages.java.BraceStyle;
import com.strobel.decompiler.languages.java.JavaFormattingOptions;
import com.strobel.decompiler.languages.java.Wrapping;
import jakarta.annotation.Nonnull;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import software.coley.observables.ObservableBoolean;
import software.coley.observables.ObservableInteger;
import software.coley.observables.ObservableObject;
import software.coley.recaf.config.BasicConfigValue;
import software.coley.recaf.services.decompile.BaseDecompilerConfig;
import software.coley.recaf.util.ExcludeFromJacocoGeneratedReport;

/**
 * Config for {@link ProcyonDecompiler}
 *
 * @author Matt Coley
 */
@ApplicationScoped
@ExcludeFromJacocoGeneratedReport(justification = "Config POJO")
public class ProcyonConfig extends BaseDecompilerConfig {
	private final ObservableBoolean includeLineNumbersInBytecode = new ObservableBoolean(true);
	private final ObservableBoolean showSyntheticMembers = new ObservableBoolean(false);
	private final ObservableBoolean alwaysGenerateExceptionVariableForCatchBlocks = new ObservableBoolean(true);
	private final ObservableBoolean forceFullyQualifiedReferences = new ObservableBoolean(false);
	private final ObservableBoolean forceExplicitImports = new ObservableBoolean(true);
	private final ObservableBoolean forceExplicitTypeArguments = new ObservableBoolean(false);
	private final ObservableBoolean flattenSwitchBlocks = new ObservableBoolean(false);
	private final ObservableBoolean excludeNestedTypes = new ObservableBoolean(false);
	private final ObservableBoolean retainRedundantCasts = new ObservableBoolean(false);
	private final ObservableBoolean retainPointlessSwitches = new ObservableBoolean(false);
	private final ObservableBoolean isUnicodeOutputEnabled = new ObservableBoolean(false);
	private final ObservableBoolean includeErrorDiagnostics = new ObservableBoolean(true);
	private final ObservableBoolean mergeVariables = new ObservableBoolean(false);
	private final ObservableBoolean disableForEachTransforms = new ObservableBoolean(false);
	private final ObservableBoolean showDebugLineNumbers = new ObservableBoolean(false);
	private final ObservableBoolean simplifyMemberReferences = new ObservableBoolean(false);
	private final ObservableBoolean arePreviewFeaturesEnabled = new ObservableBoolean(false);
	private final ObservableInteger textBlockLineMinimum = new ObservableInteger(3);
	private final ObservableObject<CompilerTarget> forcedCompilerTarget = new ObservableObject<>(null);
	private final ObservableObject<BytecodeOutputOptions> bytecodeOutputOptions = new ObservableObject<>(BytecodeOutputOptions.createDefault());
	private final ObservableObject<Language> languageTarget = new ObservableObject<>(Languages.java());

	// private final ObservableObject<BytecodeOutputOptions> bytecodeOutputOptions = new ObservableObject<>(BytecodeOutputOptions.createDefault());
	private final ObservableBoolean bytecodeOutputOptions_showTypeHeader = new ObservableBoolean(true);
	private final ObservableBoolean bytecodeOutputOptions_showTypeAttributes = new ObservableBoolean(false);
	private final ObservableBoolean bytecodeOutputOptions_showConstantPool = new ObservableBoolean(false);
	private final ObservableBoolean bytecodeOutputOptions_showFieldFlags = new ObservableBoolean(true);
	private final ObservableBoolean bytecodeOutputOptions_showFieldAttributes = new ObservableBoolean(true);
	private final ObservableBoolean bytecodeOutputOptions_showMethodsFlags = new ObservableBoolean(true);
	private final ObservableBoolean bytecodeOutputOptions_showMethodAttributes = new ObservableBoolean(true);
	private final ObservableBoolean bytecodeOutputOptions_showMethodsStack = new ObservableBoolean(false);
	private final ObservableBoolean bytecodeOutputOptions_showLineNumbers = new ObservableBoolean(true);
	private final ObservableBoolean bytecodeOutputOptions_showLocalVariableTables = new ObservableBoolean(false);
	// javaFormattingOptions
	private final ObservableBoolean javaFormattingOptions_IndentNamespaceBody = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_IndentClassBody = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_IndentInterfaceBody = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_IndentEnumBody = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_IndentMethodBody = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_IndentBlocks = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_IndentSwitchBody = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_IndentCaseBody = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_IndentBreakStatements = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_AlignEmbeddedUsingStatements = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_AlignEmbeddedIfStatements = new ObservableBoolean(true);
	private final ObservableObject<BraceStyle> javaFormattingOptions_AnonymousClassBraceStyle = new ObservableObject<>(BraceStyle.DoNotChange);
	private final ObservableObject<BraceStyle> javaFormattingOptions_ClassBraceStyle = new ObservableObject<>(BraceStyle.DoNotChange);
	private final ObservableObject<BraceStyle> javaFormattingOptions_InterfaceBraceStyle = new ObservableObject<>(BraceStyle.DoNotChange);
	private final ObservableObject<BraceStyle> javaFormattingOptions_AnnotationBraceStyle = new ObservableObject<>(BraceStyle.DoNotChange);
	private final ObservableObject<BraceStyle> javaFormattingOptions_EnumBraceStyle = new ObservableObject<>(BraceStyle.DoNotChange);
	private final ObservableObject<BraceStyle> javaFormattingOptions_ModuleBraceStyle = new ObservableObject<>(BraceStyle.DoNotChange);
	private final ObservableObject<BraceStyle> javaFormattingOptions_RecordBraceStyle = new ObservableObject<>(BraceStyle.DoNotChange);
	private final ObservableObject<BraceStyle> javaFormattingOptions_MethodBraceStyle = new ObservableObject<>(BraceStyle.DoNotChange);
	private final ObservableObject<BraceStyle> javaFormattingOptions_InitializerBlockBraceStyle = new ObservableObject<>(BraceStyle.DoNotChange);
	private final ObservableObject<BraceStyle> javaFormattingOptions_ConstructorBraceStyle = new ObservableObject<>(BraceStyle.DoNotChange);
	private final ObservableObject<BraceStyle> javaFormattingOptions_EventBraceStyle = new ObservableObject<>(BraceStyle.DoNotChange);
	private final ObservableObject<BraceStyle> javaFormattingOptions_EventAddBraceStyle = new ObservableObject<>(BraceStyle.DoNotChange);
	private final ObservableObject<BraceStyle> javaFormattingOptions_EventRemoveBraceStyle = new ObservableObject<>(BraceStyle.DoNotChange);
	private final ObservableObject<BraceStyle> javaFormattingOptions_StatementBraceStyle = new ObservableObject<>(BraceStyle.DoNotChange);
	private final ObservableBoolean javaFormattingOptions_AllowIfBlockInline = new ObservableBoolean(true);
	private final ObservableObject<BraceEnforcement> javaFormattingOptions_IfElseBraceEnforcement = new ObservableObject<>(BraceEnforcement.DoNotChange);
	private final ObservableObject<BraceEnforcement> javaFormattingOptions_ForBraceEnforcement =  new ObservableObject<>(BraceEnforcement.DoNotChange);
	private final ObservableObject<BraceEnforcement> javaFormattingOptions_ForEachBraceEnforcement =  new ObservableObject<>(BraceEnforcement.DoNotChange);
	private final ObservableObject<BraceEnforcement> javaFormattingOptions_WhileBraceEnforcement =  new ObservableObject<>(BraceEnforcement.DoNotChange);
	private final ObservableObject<BraceEnforcement> javaFormattingOptions_UsingBraceEnforcement =  new ObservableObject<>(BraceEnforcement.DoNotChange);
	private final ObservableObject<BraceEnforcement> javaFormattingOptions_FixedBraceEnforcement =  new ObservableObject<>(BraceEnforcement.DoNotChange);
	private final ObservableBoolean javaFormattingOptions_PlaceElseOnNewLine = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_PlaceElseIfOnNewLine = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_PlaceCatchOnNewLine = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_PlaceFinallyOnNewLine = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_PlaceWhileOnNewLine = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeMethodDeclarationParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBetweenEmptyMethodDeclarationParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeMethodDeclarationParameterComma = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceAfterMethodDeclarationParameterComma = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceWithinMethodDeclarationParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeMethodCallParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBetweenEmptyMethodCallParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeMethodCallParameterComma = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceAfterMethodCallParameterComma = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceWithinMethodCallParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeFieldDeclarationComma = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceAfterFieldDeclarationComma = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeLocalVariableDeclarationComma = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceAfterLocalVariableDeclarationComma = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeConstructorDeclarationParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBetweenEmptyConstructorDeclarationParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeConstructorDeclarationParameterComma = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceAfterConstructorDeclarationParameterComma = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceWithinConstructorDeclarationParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceWithinRecordDeclarationParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceWithinEnumDeclarationParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeIndexerDeclarationBracket = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceWithinIndexerDeclarationBracket = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeIndexerDeclarationParameterComma = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceAfterIndexerDeclarationParameterComma = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeDelegateDeclarationParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBetweenEmptyDelegateDeclarationParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeDelegateDeclarationParameterComma = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceAfterDelegateDeclarationParameterComma = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceWithinDelegateDeclarationParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeNewParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeIfParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeWhileParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeForParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeForeachParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeCatchParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeSwitchParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeSynchronizedParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeUsingParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceAroundAssignment = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceAroundLogicalOperator = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceAroundEqualityOperator = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceAroundRelationalOperator = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceAroundBitwiseOperator = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceAroundAdditiveOperator = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceAroundMultiplicativeOperator = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceAroundShiftOperator = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceAroundNullCoalescingOperator = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpacesWithinParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpacesWithinIfParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpacesWithinWhileParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpacesWithinForParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpacesWithinForeachParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpacesWithinCatchParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpacesWithinSwitchParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpacesWithinSynchronizedParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpacesWithinUsingParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpacesWithinCastParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpacesWithinNewParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpacesBetweenEmptyNewParentheses = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeNewParameterComma = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceAfterNewParameterComma = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeConditionalOperatorCondition = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceAfterConditionalOperatorCondition = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeConditionalOperatorSeparator = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceAfterConditionalOperatorSeparator = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpacesWithinBrackets = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpacesBeforeBrackets = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeBracketComma = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceAfterBracketComma = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeForSemicolon = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceAfterForSemicolon = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceAfterTypecast = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceBeforeArrayDeclarationBrackets = new ObservableBoolean(true);
	private final ObservableBoolean javaFormattingOptions_SpaceInNamedArgumentAfterDoubleColon = new ObservableBoolean(true);
	private final ObservableInteger javaFormattingOptions_BlankLinesAfterPackageDeclaration = new ObservableInteger(0);
	private final ObservableInteger javaFormattingOptions_BlankLinesAfterImports = new ObservableInteger(1);
	private final ObservableInteger javaFormattingOptions_BlankLinesBeforeFirstDeclaration = new ObservableInteger(0);
	private final ObservableInteger javaFormattingOptions_BlankLinesBetweenTypes = new ObservableInteger(1);
	private final ObservableInteger javaFormattingOptions_BlankLinesBetweenFields = new ObservableInteger(0);
	private final ObservableInteger javaFormattingOptions_BlankLinesBetweenEventFields = new ObservableInteger(0);
	private final ObservableInteger javaFormattingOptions_BlankLinesBetweenMembers = new ObservableInteger(1);
	private final ObservableBoolean javaFormattingOptions_KeepCommentsAtFirstColumn = new ObservableBoolean(true);
	private final ObservableObject<Wrapping> javaFormattingOptions_ArrayInitializerWrapping = new ObservableObject<>(Wrapping.DoNotWrap);
	private final ObservableObject<BraceStyle> javaFormattingOptions_ArrayInitializerBraceStyle = new ObservableObject<>(BraceStyle.DoNotChange);

	@Inject
	public ProcyonConfig() {
		super("decompiler-procyon" + CONFIG_SUFFIX);
		addValue(new BasicConfigValue<>("includeLineNumbersInBytecode", boolean.class, includeLineNumbersInBytecode));
		addValue(new BasicConfigValue<>("showSyntheticMembers", boolean.class, showSyntheticMembers));
		addValue(new BasicConfigValue<>("alwaysGenerateExceptionVariableForCatchBlocks", boolean.class, alwaysGenerateExceptionVariableForCatchBlocks));
		addValue(new BasicConfigValue<>("forceFullyQualifiedReferences", boolean.class, forceFullyQualifiedReferences));
		addValue(new BasicConfigValue<>("forceExplicitImports", boolean.class, forceExplicitImports));
		addValue(new BasicConfigValue<>("forceExplicitTypeArguments", boolean.class, forceExplicitTypeArguments));
		addValue(new BasicConfigValue<>("flattenSwitchBlocks", boolean.class, flattenSwitchBlocks));
		addValue(new BasicConfigValue<>("excludeNestedTypes", boolean.class, excludeNestedTypes));
		addValue(new BasicConfigValue<>("retainRedundantCasts", boolean.class, retainRedundantCasts));
		addValue(new BasicConfigValue<>("retainPointlessSwitches", boolean.class, retainPointlessSwitches));
		addValue(new BasicConfigValue<>("isUnicodeOutputEnabled", boolean.class, isUnicodeOutputEnabled));
		addValue(new BasicConfigValue<>("includeErrorDiagnostics", boolean.class, includeErrorDiagnostics));
		addValue(new BasicConfigValue<>("mergeVariables", boolean.class, mergeVariables));
		addValue(new BasicConfigValue<>("disableForEachTransforms", boolean.class, disableForEachTransforms));
		addValue(new BasicConfigValue<>("showDebugLineNumbers", boolean.class, showDebugLineNumbers));
		addValue(new BasicConfigValue<>("simplifyMemberReferences", boolean.class, simplifyMemberReferences));
		addValue(new BasicConfigValue<>("arePreviewFeaturesEnabled", boolean.class, arePreviewFeaturesEnabled));
		addValue(new BasicConfigValue<>("textBlockLineMinimum", int.class, textBlockLineMinimum));
		addValue(new BasicConfigValue<>("forcedCompilerTarget", CompilerTarget.class, forcedCompilerTarget));
		addValue(new BasicConfigValue<>("bytecodeOutputOptions", BytecodeOutputOptions.class, bytecodeOutputOptions));
		addValue(new BasicConfigValue<>("languageTarget", Language.class, languageTarget));
		// bytecodeOutputOptions
		addValue(new BasicConfigValue<>("bytecodeOutputOptions.showTypeHeader", boolean.class,bytecodeOutputOptions_showTypeHeader));
		addValue(new BasicConfigValue<>("bytecodeOutputOptions.showTypeAttributes", boolean.class,bytecodeOutputOptions_showTypeAttributes));
		addValue(new BasicConfigValue<>("bytecodeOutputOptions.showConstantPool", boolean.class,bytecodeOutputOptions_showConstantPool));
		addValue(new BasicConfigValue<>("bytecodeOutputOptions.showFieldFlags", boolean.class,bytecodeOutputOptions_showFieldFlags));
		addValue(new BasicConfigValue<>("bytecodeOutputOptions.showFieldAttributes", boolean.class,bytecodeOutputOptions_showFieldAttributes));
		addValue(new BasicConfigValue<>("bytecodeOutputOptions.showMethodsFlags", boolean.class,bytecodeOutputOptions_showMethodsFlags));
		addValue(new BasicConfigValue<>("bytecodeOutputOptions.showMethodAttributes", boolean.class,bytecodeOutputOptions_showMethodAttributes));
		addValue(new BasicConfigValue<>("bytecodeOutputOptions.showMethodsStack", boolean.class,bytecodeOutputOptions_showMethodsStack));
		addValue(new BasicConfigValue<>("bytecodeOutputOptions.showLineNumbers", boolean.class,bytecodeOutputOptions_showLineNumbers));
		addValue(new BasicConfigValue<>("bytecodeOutputOptions.showLocalVariableTables", boolean.class,bytecodeOutputOptions_showLocalVariableTables));
		// javaFormattingOptions
		addValue(new BasicConfigValue<>("javaFormattingOptions.IndentNamespaceBody",boolean.class,javaFormattingOptions_IndentNamespaceBody));
		addValue(new BasicConfigValue<>("javaFormattingOptions.IndentClassBody",boolean.class,javaFormattingOptions_IndentCaseBody));
		addValue(new BasicConfigValue<>("javaFormattingOptions.IndentInterfaceBody",boolean.class,javaFormattingOptions_IndentInterfaceBody));
		addValue(new BasicConfigValue<>("javaFormattingOptions.IndentEnumBody",boolean.class,javaFormattingOptions_IndentEnumBody));
		addValue(new BasicConfigValue<>("javaFormattingOptions.IndentMethodBody",boolean.class,javaFormattingOptions_IndentMethodBody));
		addValue(new BasicConfigValue<>("javaFormattingOptions.IndentBlocks",boolean.class,javaFormattingOptions_IndentBlocks));
		addValue(new BasicConfigValue<>("javaFormattingOptions.IndentSwitchBody",boolean.class,javaFormattingOptions_IndentSwitchBody));
		addValue(new BasicConfigValue<>("javaFormattingOptions.IndentCaseBody",boolean.class,javaFormattingOptions_IndentCaseBody));
		addValue(new BasicConfigValue<>("javaFormattingOptions.IndentBreakStatements",boolean.class,javaFormattingOptions_IndentBreakStatements));
		addValue(new BasicConfigValue<>("javaFormattingOptions.AlignEmbeddedUsingStatements",boolean.class,javaFormattingOptions_AlignEmbeddedUsingStatements));
		addValue(new BasicConfigValue<>("javaFormattingOptions.AlignEmbeddedIfStatements",boolean.class,javaFormattingOptions_AlignEmbeddedIfStatements));
		addValue(new BasicConfigValue<>("javaFormattingOptions.AnonymousClassBraceStyle",BraceStyle.class,javaFormattingOptions_AnonymousClassBraceStyle));
		addValue(new BasicConfigValue<>("javaFormattingOptions.ClassBraceStyle",BraceStyle.class,javaFormattingOptions_ClassBraceStyle));
		addValue(new BasicConfigValue<>("javaFormattingOptions.InterfaceBraceStyle",BraceStyle.class,javaFormattingOptions_InterfaceBraceStyle));
		addValue(new BasicConfigValue<>("javaFormattingOptions.AnnotationBraceStyle",BraceStyle.class,javaFormattingOptions_AnnotationBraceStyle));
		addValue(new BasicConfigValue<>("javaFormattingOptions.EnumBraceStyle",BraceStyle.class,javaFormattingOptions_EnumBraceStyle));
		addValue(new BasicConfigValue<>("javaFormattingOptions.ModuleBraceStyle",BraceStyle.class,javaFormattingOptions_ModuleBraceStyle));
		addValue(new BasicConfigValue<>("javaFormattingOptions.RecordBraceStyle",BraceStyle.class,javaFormattingOptions_RecordBraceStyle));
		addValue(new BasicConfigValue<>("javaFormattingOptions.MethodBraceStyle",BraceStyle.class,javaFormattingOptions_MethodBraceStyle));
		addValue(new BasicConfigValue<>("javaFormattingOptions.InitializerBlockBraceStyle",BraceStyle.class,javaFormattingOptions_InitializerBlockBraceStyle));
		addValue(new BasicConfigValue<>("javaFormattingOptions.ConstructorBraceStyle",BraceStyle.class,javaFormattingOptions_ConstructorBraceStyle));
		addValue(new BasicConfigValue<>("javaFormattingOptions.EventBraceStyle",BraceStyle.class,javaFormattingOptions_EventBraceStyle));
		addValue(new BasicConfigValue<>("javaFormattingOptions.EventAddBraceStyle",BraceStyle.class,javaFormattingOptions_EventAddBraceStyle));
		addValue(new BasicConfigValue<>("javaFormattingOptions.EventRemoveBraceStyle",BraceStyle.class,javaFormattingOptions_EventRemoveBraceStyle));
		addValue(new BasicConfigValue<>("javaFormattingOptions.StatementBraceStyle",BraceStyle.class,javaFormattingOptions_StatementBraceStyle));
		addValue(new BasicConfigValue<>("javaFormattingOptions.AllowIfBlockInline",boolean.class,javaFormattingOptions_AllowIfBlockInline));
		addValue(new BasicConfigValue<>("javaFormattingOptions.IfElseBraceEnforcement",BraceEnforcement.class,javaFormattingOptions_IfElseBraceEnforcement));
		addValue(new BasicConfigValue<>("javaFormattingOptions.ForBraceEnforcement",BraceEnforcement.class,javaFormattingOptions_ForBraceEnforcement));
		addValue(new BasicConfigValue<>("javaFormattingOptions.ForEachBraceEnforcement",BraceEnforcement.class,javaFormattingOptions_ForEachBraceEnforcement));
		addValue(new BasicConfigValue<>("javaFormattingOptions.WhileBraceEnforcement",BraceEnforcement.class,javaFormattingOptions_WhileBraceEnforcement));
		addValue(new BasicConfigValue<>("javaFormattingOptions.UsingBraceEnforcement",BraceEnforcement.class,javaFormattingOptions_UsingBraceEnforcement));
		addValue(new BasicConfigValue<>("javaFormattingOptions.FixedBraceEnforcement",BraceEnforcement.class,javaFormattingOptions_FixedBraceEnforcement));
		addValue(new BasicConfigValue<>("javaFormattingOptions.PlaceElseOnNewLine",boolean.class,javaFormattingOptions_PlaceElseOnNewLine));
		addValue(new BasicConfigValue<>("javaFormattingOptions.PlaceElseIfOnNewLine",boolean.class,javaFormattingOptions_PlaceElseIfOnNewLine));
		addValue(new BasicConfigValue<>("javaFormattingOptions.PlaceCatchOnNewLine",boolean.class,javaFormattingOptions_PlaceCatchOnNewLine));
		addValue(new BasicConfigValue<>("javaFormattingOptions.PlaceFinallyOnNewLine",boolean.class,javaFormattingOptions_PlaceFinallyOnNewLine));
		addValue(new BasicConfigValue<>("javaFormattingOptions.PlaceWhileOnNewLine",boolean.class,javaFormattingOptions_PlaceWhileOnNewLine));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeMethodDeclarationParentheses",boolean.class,javaFormattingOptions_SpaceBeforeMethodDeclarationParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBetweenEmptyMethodDeclarationParentheses",boolean.class,javaFormattingOptions_SpaceBetweenEmptyMethodDeclarationParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeMethodDeclarationParameterComma",boolean.class,javaFormattingOptions_SpaceBeforeMethodDeclarationParameterComma));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceAfterMethodDeclarationParameterComma",boolean.class,javaFormattingOptions_SpaceAfterMethodDeclarationParameterComma));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceWithinMethodDeclarationParentheses",boolean.class,javaFormattingOptions_SpaceWithinMethodDeclarationParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeMethodCallParentheses",boolean.class,javaFormattingOptions_SpaceBeforeMethodCallParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBetweenEmptyMethodCallParentheses",boolean.class,javaFormattingOptions_SpaceBetweenEmptyMethodCallParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeMethodCallParameterComma",boolean.class,javaFormattingOptions_SpaceBeforeMethodCallParameterComma));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceAfterMethodCallParameterComma",boolean.class,javaFormattingOptions_SpaceAfterMethodCallParameterComma));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceWithinMethodCallParentheses",boolean.class,javaFormattingOptions_SpaceWithinMethodCallParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeFieldDeclarationComma",boolean.class,javaFormattingOptions_SpaceBeforeFieldDeclarationComma));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceAfterFieldDeclarationComma",boolean.class,javaFormattingOptions_SpaceAfterFieldDeclarationComma));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeLocalVariableDeclarationComma",boolean.class,javaFormattingOptions_SpaceBeforeLocalVariableDeclarationComma));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceAfterLocalVariableDeclarationComma",boolean.class,javaFormattingOptions_SpaceAfterLocalVariableDeclarationComma));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeConstructorDeclarationParentheses",boolean.class,javaFormattingOptions_SpaceBeforeConstructorDeclarationParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBetweenEmptyConstructorDeclarationParentheses",boolean.class,javaFormattingOptions_SpaceBetweenEmptyConstructorDeclarationParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeConstructorDeclarationParameterComma",boolean.class,javaFormattingOptions_SpaceBeforeConstructorDeclarationParameterComma));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceAfterConstructorDeclarationParameterComma",boolean.class,javaFormattingOptions_SpaceAfterConstructorDeclarationParameterComma));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceWithinConstructorDeclarationParentheses",boolean.class,javaFormattingOptions_SpaceWithinConstructorDeclarationParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceWithinRecordDeclarationParentheses",boolean.class,javaFormattingOptions_SpaceWithinRecordDeclarationParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceWithinEnumDeclarationParentheses",boolean.class,javaFormattingOptions_SpaceWithinEnumDeclarationParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeIndexerDeclarationBracket",boolean.class,javaFormattingOptions_SpaceBeforeIndexerDeclarationBracket));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceWithinIndexerDeclarationBracket",boolean.class,javaFormattingOptions_SpaceWithinIndexerDeclarationBracket));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeIndexerDeclarationParameterComma",boolean.class,javaFormattingOptions_SpaceBeforeIndexerDeclarationParameterComma));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceAfterIndexerDeclarationParameterComma",boolean.class,javaFormattingOptions_SpaceAfterIndexerDeclarationParameterComma));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeDelegateDeclarationParentheses",boolean.class,javaFormattingOptions_SpaceBeforeDelegateDeclarationParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBetweenEmptyDelegateDeclarationParentheses",boolean.class,javaFormattingOptions_SpaceBetweenEmptyDelegateDeclarationParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeDelegateDeclarationParameterComma",boolean.class,javaFormattingOptions_SpaceBeforeDelegateDeclarationParameterComma));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceAfterDelegateDeclarationParameterComma",boolean.class,javaFormattingOptions_SpaceAfterDelegateDeclarationParameterComma));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceWithinDelegateDeclarationParentheses",boolean.class,javaFormattingOptions_SpaceWithinDelegateDeclarationParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeNewParentheses",boolean.class,javaFormattingOptions_SpaceBeforeNewParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeIfParentheses",boolean.class,javaFormattingOptions_SpaceBeforeIfParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeWhileParentheses",boolean.class,javaFormattingOptions_SpaceBeforeWhileParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeForParentheses",boolean.class,javaFormattingOptions_SpaceBeforeForParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeForeachParentheses",boolean.class,javaFormattingOptions_SpaceBeforeForeachParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeCatchParentheses",boolean.class,javaFormattingOptions_SpaceBeforeCatchParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeSwitchParentheses",boolean.class,javaFormattingOptions_SpaceBeforeSwitchParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeSynchronizedParentheses",boolean.class,javaFormattingOptions_SpaceBeforeSynchronizedParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeUsingParentheses",boolean.class,javaFormattingOptions_SpaceBeforeUsingParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceAroundAssignment",boolean.class,javaFormattingOptions_SpaceAroundAssignment));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceAroundLogicalOperator",boolean.class,javaFormattingOptions_SpaceAroundLogicalOperator));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceAroundEqualityOperator",boolean.class,javaFormattingOptions_SpaceAroundEqualityOperator));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceAroundRelationalOperator",boolean.class,javaFormattingOptions_SpaceAroundRelationalOperator));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceAroundBitwiseOperator",boolean.class,javaFormattingOptions_SpaceAroundBitwiseOperator));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceAroundAdditiveOperator",boolean.class,javaFormattingOptions_SpaceAroundAdditiveOperator));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceAroundMultiplicativeOperator",boolean.class,javaFormattingOptions_SpaceAroundMultiplicativeOperator));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceAroundShiftOperator",boolean.class,javaFormattingOptions_SpaceAroundShiftOperator));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceAroundNullCoalescingOperator",boolean.class,javaFormattingOptions_SpaceAroundNullCoalescingOperator));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpacesWithinParentheses",boolean.class,javaFormattingOptions_SpacesWithinParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpacesWithinIfParentheses",boolean.class,javaFormattingOptions_SpacesWithinIfParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpacesWithinWhileParentheses",boolean.class,javaFormattingOptions_SpacesWithinWhileParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpacesWithinForParentheses",boolean.class,javaFormattingOptions_SpacesWithinForParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpacesWithinForeachParentheses",boolean.class,javaFormattingOptions_SpacesWithinForeachParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpacesWithinCatchParentheses",boolean.class,javaFormattingOptions_SpacesWithinCatchParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpacesWithinSwitchParentheses",boolean.class,javaFormattingOptions_SpacesWithinSwitchParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpacesWithinSynchronizedParentheses",boolean.class,javaFormattingOptions_SpacesWithinSynchronizedParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpacesWithinUsingParentheses",boolean.class,javaFormattingOptions_SpacesWithinUsingParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpacesWithinCastParentheses",boolean.class,javaFormattingOptions_SpacesWithinCastParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpacesWithinNewParentheses",boolean.class,javaFormattingOptions_SpacesWithinNewParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpacesBetweenEmptyNewParentheses",boolean.class,javaFormattingOptions_SpacesBetweenEmptyNewParentheses));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeNewParameterComma",boolean.class,javaFormattingOptions_SpaceBeforeNewParameterComma));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceAfterNewParameterComma",boolean.class,javaFormattingOptions_SpaceAfterNewParameterComma));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeConditionalOperatorCondition",boolean.class,javaFormattingOptions_SpaceBeforeConditionalOperatorCondition));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceAfterConditionalOperatorCondition",boolean.class,javaFormattingOptions_SpaceAfterConditionalOperatorCondition));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeConditionalOperatorSeparator",boolean.class,javaFormattingOptions_SpaceBeforeConditionalOperatorSeparator));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceAfterConditionalOperatorSeparator",boolean.class,javaFormattingOptions_SpaceAfterConditionalOperatorSeparator));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpacesWithinBrackets",boolean.class,javaFormattingOptions_SpacesWithinBrackets));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpacesBeforeBrackets",boolean.class,javaFormattingOptions_SpacesBeforeBrackets));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeBracketComma",boolean.class,javaFormattingOptions_SpaceBeforeBracketComma));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceAfterBracketComma",boolean.class,javaFormattingOptions_SpaceAfterBracketComma));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeForSemicolon",boolean.class,javaFormattingOptions_SpaceBeforeForSemicolon));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceAfterForSemicolon",boolean.class,javaFormattingOptions_SpaceAfterForSemicolon));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceAfterTypecast",boolean.class,javaFormattingOptions_SpaceAfterTypecast));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceBeforeArrayDeclarationBrackets",boolean.class,javaFormattingOptions_SpaceBeforeArrayDeclarationBrackets));
		addValue(new BasicConfigValue<>("javaFormattingOptions.SpaceInNamedArgumentAfterDoubleColon",boolean.class,javaFormattingOptions_SpaceInNamedArgumentAfterDoubleColon));
		addValue(new BasicConfigValue<>("javaFormattingOptions.BlankLinesAfterPackageDeclaration",int.class,javaFormattingOptions_BlankLinesAfterPackageDeclaration));
		addValue(new BasicConfigValue<>("javaFormattingOptions.BlankLinesAfterImports",int.class,javaFormattingOptions_BlankLinesAfterImports));
		addValue(new BasicConfigValue<>("javaFormattingOptions.BlankLinesBeforeFirstDeclaration",int.class,javaFormattingOptions_BlankLinesBeforeFirstDeclaration));
		addValue(new BasicConfigValue<>("javaFormattingOptions.BlankLinesBetweenTypes",int.class,javaFormattingOptions_BlankLinesBetweenTypes));
		addValue(new BasicConfigValue<>("javaFormattingOptions.BlankLinesBetweenFields",int.class,javaFormattingOptions_BlankLinesBetweenFields));
		addValue(new BasicConfigValue<>("javaFormattingOptions.BlankLinesBetweenEventFields",int.class,javaFormattingOptions_BlankLinesBetweenEventFields));
		addValue(new BasicConfigValue<>("javaFormattingOptions.BlankLinesBetweenMembers",int.class,javaFormattingOptions_BlankLinesBetweenMembers));
		addValue(new BasicConfigValue<>("javaFormattingOptions.KeepCommentsAtFirstColumn",boolean.class,javaFormattingOptions_KeepCommentsAtFirstColumn));
		addValue(new BasicConfigValue<>("javaFormattingOptions.ArrayInitializerWrapping",Wrapping.class,javaFormattingOptions_ArrayInitializerWrapping));
		addValue(new BasicConfigValue<>("javaFormattingOptions.ArrayInitializerBraceStyle",BraceStyle.class,javaFormattingOptions_ArrayInitializerBraceStyle));
		registerConfigValuesHashUpdates();
	}

	/**
	 * @return Settings wrapper.
	 */
	@Nonnull
	public DecompilerSettings toSettings() {
		DecompilerSettings decompilerSettings = new DecompilerSettings();
		decompilerSettings.setIncludeLineNumbersInBytecode(includeLineNumbersInBytecode.getValue());
		decompilerSettings.setShowSyntheticMembers(showSyntheticMembers.getValue());
		decompilerSettings.setAlwaysGenerateExceptionVariableForCatchBlocks(alwaysGenerateExceptionVariableForCatchBlocks.getValue());
		decompilerSettings.setForceFullyQualifiedReferences(forceFullyQualifiedReferences.getValue());
		decompilerSettings.setForceExplicitImports(forceExplicitImports.getValue());
		decompilerSettings.setForceExplicitTypeArguments(forceExplicitTypeArguments.getValue());
		decompilerSettings.setFlattenSwitchBlocks(flattenSwitchBlocks.getValue());
		decompilerSettings.setExcludeNestedTypes(excludeNestedTypes.getValue());
		decompilerSettings.setRetainRedundantCasts(retainRedundantCasts.getValue());
		decompilerSettings.setRetainPointlessSwitches(retainPointlessSwitches.getValue());
		decompilerSettings.setUnicodeOutputEnabled(isUnicodeOutputEnabled.getValue());
		decompilerSettings.setIncludeErrorDiagnostics(includeErrorDiagnostics.getValue());
		decompilerSettings.setMergeVariables(mergeVariables.getValue());
		decompilerSettings.setDisableForEachTransforms(disableForEachTransforms.getValue());
		decompilerSettings.setShowDebugLineNumbers(showDebugLineNumbers.getValue());
		decompilerSettings.setSimplifyMemberReferences(simplifyMemberReferences.getValue());
		decompilerSettings.setPreviewFeaturesEnabled(arePreviewFeaturesEnabled.getValue());
		decompilerSettings.setTextBlockLineMinimum(textBlockLineMinimum.getValue());
		decompilerSettings.setForcedCompilerTarget(forcedCompilerTarget.getValue());
		decompilerSettings.setBytecodeOutputOptions(bytecodeOutputOptions.getValue());
		decompilerSettings.setLanguage(languageTarget.getValue());

		BytecodeOutputOptions bytecodeOutputOptions = BytecodeOutputOptions.createDefault();
		bytecodeOutputOptions.showTypeHeader = bytecodeOutputOptions_showTypeHeader.getValue();
		bytecodeOutputOptions.showTypeAttributes = bytecodeOutputOptions_showTypeAttributes.getValue();
		bytecodeOutputOptions.showConstantPool = bytecodeOutputOptions_showConstantPool.getValue();
		bytecodeOutputOptions.showFieldFlags = bytecodeOutputOptions_showFieldFlags.getValue();
		bytecodeOutputOptions.showFieldAttributes = bytecodeOutputOptions_showFieldAttributes.getValue();
		bytecodeOutputOptions.showMethodsFlags = bytecodeOutputOptions_showMethodsFlags.getValue();
		bytecodeOutputOptions.showMethodAttributes = bytecodeOutputOptions_showMethodAttributes.getValue();
		bytecodeOutputOptions.showMethodsStack = bytecodeOutputOptions_showMethodsStack.getValue();
		bytecodeOutputOptions.showLineNumbers = bytecodeOutputOptions_showLineNumbers.getValue();
		bytecodeOutputOptions.showLocalVariableTables = bytecodeOutputOptions_showLocalVariableTables.getValue();
		decompilerSettings.setBytecodeOutputOptions(bytecodeOutputOptions);

		JavaFormattingOptions javaFormattingOptions = JavaFormattingOptions.createDefault();
		javaFormattingOptions.IndentNamespaceBody=javaFormattingOptions_IndentNamespaceBody.getValue();
		javaFormattingOptions.IndentClassBody=javaFormattingOptions_IndentClassBody.getValue();
		javaFormattingOptions.IndentInterfaceBody=javaFormattingOptions_IndentInterfaceBody.getValue();
		javaFormattingOptions.IndentEnumBody=javaFormattingOptions_IndentEnumBody.getValue();
		javaFormattingOptions.IndentMethodBody=javaFormattingOptions_IndentMethodBody.getValue();
		javaFormattingOptions.IndentBlocks=javaFormattingOptions_IndentBlocks.getValue();
		javaFormattingOptions.IndentSwitchBody=javaFormattingOptions_IndentSwitchBody.getValue();
		javaFormattingOptions.IndentCaseBody=javaFormattingOptions_IndentCaseBody.getValue();
		javaFormattingOptions.IndentBreakStatements=javaFormattingOptions_IndentBreakStatements.getValue();
		javaFormattingOptions.AlignEmbeddedUsingStatements=javaFormattingOptions_AlignEmbeddedUsingStatements.getValue();
		javaFormattingOptions.AlignEmbeddedIfStatements=javaFormattingOptions_AlignEmbeddedIfStatements.getValue();
		javaFormattingOptions.AnonymousClassBraceStyle=javaFormattingOptions_AnonymousClassBraceStyle.getValue();
		javaFormattingOptions.ClassBraceStyle=javaFormattingOptions_ClassBraceStyle.getValue();
		javaFormattingOptions.InterfaceBraceStyle=javaFormattingOptions_InterfaceBraceStyle.getValue();
		javaFormattingOptions.AnnotationBraceStyle=javaFormattingOptions_AnnotationBraceStyle.getValue();
		javaFormattingOptions.EnumBraceStyle=javaFormattingOptions_EnumBraceStyle.getValue();
		javaFormattingOptions.ModuleBraceStyle=javaFormattingOptions_ModuleBraceStyle.getValue();
		javaFormattingOptions.RecordBraceStyle=javaFormattingOptions_RecordBraceStyle.getValue();
		javaFormattingOptions.MethodBraceStyle=javaFormattingOptions_MethodBraceStyle.getValue();
		javaFormattingOptions.InitializerBlockBraceStyle=javaFormattingOptions_InitializerBlockBraceStyle.getValue();
		javaFormattingOptions.ConstructorBraceStyle=javaFormattingOptions_ConstructorBraceStyle.getValue();
		javaFormattingOptions.EventBraceStyle=javaFormattingOptions_EventBraceStyle.getValue();
		javaFormattingOptions.EventAddBraceStyle=javaFormattingOptions_EventAddBraceStyle.getValue();
		javaFormattingOptions.EventRemoveBraceStyle=javaFormattingOptions_EventRemoveBraceStyle.getValue();
		javaFormattingOptions.StatementBraceStyle=javaFormattingOptions_StatementBraceStyle.getValue();
		javaFormattingOptions.AllowIfBlockInline=javaFormattingOptions_AllowIfBlockInline.getValue();
		javaFormattingOptions.IfElseBraceEnforcement=javaFormattingOptions_IfElseBraceEnforcement.getValue();
		javaFormattingOptions.ForBraceEnforcement=javaFormattingOptions_ForBraceEnforcement.getValue();
		javaFormattingOptions.ForEachBraceEnforcement=javaFormattingOptions_ForEachBraceEnforcement.getValue();
		javaFormattingOptions.WhileBraceEnforcement=javaFormattingOptions_WhileBraceEnforcement.getValue();
		javaFormattingOptions.UsingBraceEnforcement=javaFormattingOptions_UsingBraceEnforcement.getValue();
		javaFormattingOptions.FixedBraceEnforcement=javaFormattingOptions_FixedBraceEnforcement.getValue();
		javaFormattingOptions.PlaceElseOnNewLine=javaFormattingOptions_PlaceElseOnNewLine.getValue();
		javaFormattingOptions.PlaceElseIfOnNewLine=javaFormattingOptions_PlaceElseIfOnNewLine.getValue();
		javaFormattingOptions.PlaceCatchOnNewLine=javaFormattingOptions_PlaceCatchOnNewLine.getValue();
		javaFormattingOptions.PlaceFinallyOnNewLine=javaFormattingOptions_PlaceFinallyOnNewLine.getValue();
		javaFormattingOptions.PlaceWhileOnNewLine=javaFormattingOptions_PlaceWhileOnNewLine.getValue();
		javaFormattingOptions.SpaceBeforeMethodDeclarationParentheses=javaFormattingOptions_SpaceBeforeMethodDeclarationParentheses.getValue();
		javaFormattingOptions.SpaceBetweenEmptyMethodDeclarationParentheses=javaFormattingOptions_SpaceBetweenEmptyMethodDeclarationParentheses.getValue();
		javaFormattingOptions.SpaceBeforeMethodDeclarationParameterComma=javaFormattingOptions_SpaceBeforeMethodDeclarationParameterComma.getValue();
		javaFormattingOptions.SpaceAfterMethodDeclarationParameterComma=javaFormattingOptions_SpaceAfterMethodDeclarationParameterComma.getValue();
		javaFormattingOptions.SpaceWithinMethodDeclarationParentheses=javaFormattingOptions_SpaceWithinMethodDeclarationParentheses.getValue();
		javaFormattingOptions.SpaceBeforeMethodCallParentheses=javaFormattingOptions_SpaceBeforeMethodCallParentheses.getValue();
		javaFormattingOptions.SpaceBetweenEmptyMethodCallParentheses=javaFormattingOptions_SpaceBetweenEmptyMethodCallParentheses.getValue();
		javaFormattingOptions.SpaceBeforeMethodCallParameterComma=javaFormattingOptions_SpaceBeforeMethodCallParameterComma.getValue();
		javaFormattingOptions.SpaceAfterMethodCallParameterComma=javaFormattingOptions_SpaceAfterMethodCallParameterComma.getValue();
		javaFormattingOptions.SpaceWithinMethodCallParentheses=javaFormattingOptions_SpaceWithinMethodCallParentheses.getValue();
		javaFormattingOptions.SpaceBeforeFieldDeclarationComma=javaFormattingOptions_SpaceBeforeFieldDeclarationComma.getValue();
		javaFormattingOptions.SpaceAfterFieldDeclarationComma=javaFormattingOptions_SpaceAfterFieldDeclarationComma.getValue();
		javaFormattingOptions.SpaceBeforeLocalVariableDeclarationComma=javaFormattingOptions_SpaceBeforeLocalVariableDeclarationComma.getValue();
		javaFormattingOptions.SpaceAfterLocalVariableDeclarationComma=javaFormattingOptions_SpaceAfterLocalVariableDeclarationComma.getValue();
		javaFormattingOptions.SpaceBeforeConstructorDeclarationParentheses=javaFormattingOptions_SpaceBeforeConstructorDeclarationParentheses.getValue();
		javaFormattingOptions.SpaceBetweenEmptyConstructorDeclarationParentheses=javaFormattingOptions_SpaceBetweenEmptyConstructorDeclarationParentheses.getValue();
		javaFormattingOptions.SpaceBeforeConstructorDeclarationParameterComma=javaFormattingOptions_SpaceBeforeConstructorDeclarationParameterComma.getValue();
		javaFormattingOptions.SpaceAfterConstructorDeclarationParameterComma=javaFormattingOptions_SpaceAfterConstructorDeclarationParameterComma.getValue();
		javaFormattingOptions.SpaceWithinConstructorDeclarationParentheses=javaFormattingOptions_SpaceWithinConstructorDeclarationParentheses.getValue();
		javaFormattingOptions.SpaceWithinRecordDeclarationParentheses=javaFormattingOptions_SpaceWithinRecordDeclarationParentheses.getValue();
		javaFormattingOptions.SpaceWithinEnumDeclarationParentheses=javaFormattingOptions_SpaceWithinEnumDeclarationParentheses.getValue();
		javaFormattingOptions.SpaceBeforeIndexerDeclarationBracket=javaFormattingOptions_SpaceBeforeIndexerDeclarationBracket.getValue();
		javaFormattingOptions.SpaceWithinIndexerDeclarationBracket=javaFormattingOptions_SpaceWithinIndexerDeclarationBracket.getValue();
		javaFormattingOptions.SpaceBeforeIndexerDeclarationParameterComma=javaFormattingOptions_SpaceBeforeIndexerDeclarationParameterComma.getValue();
		javaFormattingOptions.SpaceAfterIndexerDeclarationParameterComma=javaFormattingOptions_SpaceAfterIndexerDeclarationParameterComma.getValue();
		javaFormattingOptions.SpaceBeforeDelegateDeclarationParentheses=javaFormattingOptions_SpaceBeforeDelegateDeclarationParentheses.getValue();
		javaFormattingOptions.SpaceBetweenEmptyDelegateDeclarationParentheses=javaFormattingOptions_SpaceBetweenEmptyDelegateDeclarationParentheses.getValue();
		javaFormattingOptions.SpaceBeforeDelegateDeclarationParameterComma=javaFormattingOptions_SpaceBeforeDelegateDeclarationParameterComma.getValue();
		javaFormattingOptions.SpaceAfterDelegateDeclarationParameterComma=javaFormattingOptions_SpaceAfterDelegateDeclarationParameterComma.getValue();
		javaFormattingOptions.SpaceWithinDelegateDeclarationParentheses=javaFormattingOptions_SpaceWithinDelegateDeclarationParentheses.getValue();
		javaFormattingOptions.SpaceBeforeNewParentheses=javaFormattingOptions_SpaceBeforeNewParentheses.getValue();
		javaFormattingOptions.SpaceBeforeIfParentheses=javaFormattingOptions_SpaceBeforeIfParentheses.getValue();
		javaFormattingOptions.SpaceBeforeWhileParentheses=javaFormattingOptions_SpaceBeforeWhileParentheses.getValue();
		javaFormattingOptions.SpaceBeforeForParentheses=javaFormattingOptions_SpaceBeforeForParentheses.getValue();
		javaFormattingOptions.SpaceBeforeForeachParentheses=javaFormattingOptions_SpaceBeforeForeachParentheses.getValue();
		javaFormattingOptions.SpaceBeforeCatchParentheses=javaFormattingOptions_SpaceBeforeCatchParentheses.getValue();
		javaFormattingOptions.SpaceBeforeSwitchParentheses=javaFormattingOptions_SpaceBeforeSwitchParentheses.getValue();
		javaFormattingOptions.SpaceBeforeSynchronizedParentheses=javaFormattingOptions_SpaceBeforeSynchronizedParentheses.getValue();
		javaFormattingOptions.SpaceBeforeUsingParentheses=javaFormattingOptions_SpaceBeforeUsingParentheses.getValue();
		javaFormattingOptions.SpaceAroundAssignment=javaFormattingOptions_SpaceAroundAssignment.getValue();
		javaFormattingOptions.SpaceAroundLogicalOperator=javaFormattingOptions_SpaceAroundLogicalOperator.getValue();
		javaFormattingOptions.SpaceAroundEqualityOperator=javaFormattingOptions_SpaceAroundEqualityOperator.getValue();
		javaFormattingOptions.SpaceAroundRelationalOperator=javaFormattingOptions_SpaceAroundRelationalOperator.getValue();
		javaFormattingOptions.SpaceAroundBitwiseOperator=javaFormattingOptions_SpaceAroundBitwiseOperator.getValue();
		javaFormattingOptions.SpaceAroundAdditiveOperator=javaFormattingOptions_SpaceAroundAdditiveOperator.getValue();
		javaFormattingOptions.SpaceAroundMultiplicativeOperator=javaFormattingOptions_SpaceAroundMultiplicativeOperator.getValue();
		javaFormattingOptions.SpaceAroundShiftOperator=javaFormattingOptions_SpaceAroundShiftOperator.getValue();
		javaFormattingOptions.SpaceAroundNullCoalescingOperator=javaFormattingOptions_SpaceAroundNullCoalescingOperator.getValue();
		javaFormattingOptions.SpacesWithinParentheses=javaFormattingOptions_SpacesWithinParentheses.getValue();
		javaFormattingOptions.SpacesWithinIfParentheses=javaFormattingOptions_SpacesWithinIfParentheses.getValue();
		javaFormattingOptions.SpacesWithinWhileParentheses=javaFormattingOptions_SpacesWithinWhileParentheses.getValue();
		javaFormattingOptions.SpacesWithinForParentheses=javaFormattingOptions_SpacesWithinForParentheses.getValue();
		javaFormattingOptions.SpacesWithinForeachParentheses=javaFormattingOptions_SpacesWithinForeachParentheses.getValue();
		javaFormattingOptions.SpacesWithinCatchParentheses=javaFormattingOptions_SpacesWithinCatchParentheses.getValue();
		javaFormattingOptions.SpacesWithinSwitchParentheses=javaFormattingOptions_SpacesWithinSwitchParentheses.getValue();
		javaFormattingOptions.SpacesWithinSynchronizedParentheses=javaFormattingOptions_SpacesWithinSynchronizedParentheses.getValue();
		javaFormattingOptions.SpacesWithinUsingParentheses=javaFormattingOptions_SpacesWithinUsingParentheses.getValue();
		javaFormattingOptions.SpacesWithinCastParentheses=javaFormattingOptions_SpacesWithinCastParentheses.getValue();
		javaFormattingOptions.SpacesWithinNewParentheses=javaFormattingOptions_SpacesWithinNewParentheses.getValue();
		javaFormattingOptions.SpacesBetweenEmptyNewParentheses=javaFormattingOptions_SpacesBetweenEmptyNewParentheses.getValue();
		javaFormattingOptions.SpaceBeforeNewParameterComma=javaFormattingOptions_SpaceBeforeNewParameterComma.getValue();
		javaFormattingOptions.SpaceAfterNewParameterComma=javaFormattingOptions_SpaceAfterNewParameterComma.getValue();
		javaFormattingOptions.SpaceBeforeConditionalOperatorCondition=javaFormattingOptions_SpaceBeforeConditionalOperatorCondition.getValue();
		javaFormattingOptions.SpaceAfterConditionalOperatorCondition=javaFormattingOptions_SpaceAfterConditionalOperatorCondition.getValue();
		javaFormattingOptions.SpaceBeforeConditionalOperatorSeparator=javaFormattingOptions_SpaceBeforeConditionalOperatorSeparator.getValue();
		javaFormattingOptions.SpaceAfterConditionalOperatorSeparator=javaFormattingOptions_SpaceAfterConditionalOperatorSeparator.getValue();
		javaFormattingOptions.SpacesWithinBrackets=javaFormattingOptions_SpacesWithinBrackets.getValue();
		javaFormattingOptions.SpacesBeforeBrackets=javaFormattingOptions_SpacesBeforeBrackets.getValue();
		javaFormattingOptions.SpaceBeforeBracketComma=javaFormattingOptions_SpaceBeforeBracketComma.getValue();
		javaFormattingOptions.SpaceAfterBracketComma=javaFormattingOptions_SpaceAfterBracketComma.getValue();
		javaFormattingOptions.SpaceBeforeForSemicolon=javaFormattingOptions_SpaceBeforeForSemicolon.getValue();
		javaFormattingOptions.SpaceAfterForSemicolon=javaFormattingOptions_SpaceAfterForSemicolon.getValue();
		javaFormattingOptions.SpaceAfterTypecast=javaFormattingOptions_SpaceAfterTypecast.getValue();
		javaFormattingOptions.SpaceBeforeArrayDeclarationBrackets=javaFormattingOptions_SpaceBeforeArrayDeclarationBrackets.getValue();
		javaFormattingOptions.SpaceInNamedArgumentAfterDoubleColon=javaFormattingOptions_SpaceInNamedArgumentAfterDoubleColon.getValue();
		javaFormattingOptions.BlankLinesAfterPackageDeclaration=javaFormattingOptions_BlankLinesAfterPackageDeclaration.getValue();
		javaFormattingOptions.BlankLinesAfterImports=javaFormattingOptions_BlankLinesAfterImports.getValue();
		javaFormattingOptions.BlankLinesBeforeFirstDeclaration=javaFormattingOptions_BlankLinesBeforeFirstDeclaration.getValue();
		javaFormattingOptions.BlankLinesBetweenTypes=javaFormattingOptions_BlankLinesBetweenTypes.getValue();
		javaFormattingOptions.BlankLinesBetweenFields=javaFormattingOptions_BlankLinesBetweenFields.getValue();
		javaFormattingOptions.BlankLinesBetweenEventFields=javaFormattingOptions_BlankLinesBetweenEventFields.getValue();
		javaFormattingOptions.BlankLinesBetweenMembers=javaFormattingOptions_BlankLinesBetweenMembers.getValue();
		javaFormattingOptions.KeepCommentsAtFirstColumn=javaFormattingOptions_KeepCommentsAtFirstColumn.getValue();
		javaFormattingOptions.ArrayInitializerWrapping=javaFormattingOptions_ArrayInitializerWrapping.getValue();
		javaFormattingOptions.ArrayInitializerBraceStyle=javaFormattingOptions_ArrayInitializerBraceStyle.getValue();

		return decompilerSettings;
	}

	@Nonnull
	public ObservableBoolean getIncludeLineNumbersInBytecode() {
		return includeLineNumbersInBytecode;
	}

	@Nonnull
	public ObservableBoolean getShowSyntheticMembers() {
		return showSyntheticMembers;
	}

	@Nonnull
	public ObservableBoolean getAlwaysGenerateExceptionVariableForCatchBlocks() {
		return alwaysGenerateExceptionVariableForCatchBlocks;
	}

	@Nonnull
	public ObservableBoolean getForceFullyQualifiedReferences() {
		return forceFullyQualifiedReferences;
	}

	@Nonnull
	public ObservableBoolean getForceExplicitImports() {
		return forceExplicitImports;
	}

	@Nonnull
	public ObservableBoolean getForceExplicitTypeArguments() {
		return forceExplicitTypeArguments;
	}

	@Nonnull
	public ObservableBoolean getFlattenSwitchBlocks() {
		return flattenSwitchBlocks;
	}

	@Nonnull
	public ObservableBoolean getExcludeNestedTypes() {
		return excludeNestedTypes;
	}

	@Nonnull
	public ObservableBoolean getRetainRedundantCasts() {
		return retainRedundantCasts;
	}

	@Nonnull
	public ObservableBoolean getRetainPointlessSwitches() {
		return retainPointlessSwitches;
	}

	@Nonnull
	public ObservableBoolean getIsUnicodeOutputEnabled() {
		return isUnicodeOutputEnabled;
	}

	@Nonnull
	public ObservableBoolean getIncludeErrorDiagnostics() {
		return includeErrorDiagnostics;
	}

	@Nonnull
	public ObservableBoolean getMergeVariables() {
		return mergeVariables;
	}

	@Nonnull
	public ObservableBoolean getDisableForEachTransforms() {
		return disableForEachTransforms;
	}

	@Nonnull
	public ObservableBoolean getShowDebugLineNumbers() {
		return showDebugLineNumbers;
	}

	@Nonnull
	public ObservableBoolean getSimplifyMemberReferences() {
		return simplifyMemberReferences;
	}

	@Nonnull
	public ObservableBoolean getArePreviewFeaturesEnabled() {
		return arePreviewFeaturesEnabled;
	}

	@Nonnull
	public ObservableInteger getTextBlockLineMinimum() {
		return textBlockLineMinimum;
	}

	@Nonnull
	public ObservableObject<CompilerTarget> getForcedCompilerTarget() {
		return forcedCompilerTarget;
	}

	@Nonnull
	public ObservableBoolean getBytecodeOutputOptions_showLineNumbers() {
		return bytecodeOutputOptions_showLineNumbers;
	}

	@Nonnull
	public ObservableObject<Language> getLanguageTarget() {
		return languageTarget;
	}
}
