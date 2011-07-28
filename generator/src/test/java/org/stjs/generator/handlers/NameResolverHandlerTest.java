package org.stjs.generator.handlers;

import static org.stjs.generator.GeneratedScriptTester.handlerTester;
import static org.stjs.generator.GenerationContextFactory.context;
import static org.stjs.generator.NodesFactory.nameExpr;
import org.junit.Test;
import org.stjs.generator.scope.JavaTypeName;
import org.stjs.generator.scope.NameType.IdentifierName;
import org.stjs.generator.scope.QualifiedName;
import org.stjs.generator.scope.TypeScope;


public class NameResolverHandlerTest {

  @Test
  public void shouldQualifyStaticMememberAccess() throws Exception {
    TypeScope scope = new TypeScope(null, null, new JavaTypeName("MyClass"), null);
    handlerTester(NameResolverHandler.class, false).
    assertGenerateString("MyClass.MY_CONSTANT",
      nameExpr("MY_CONSTANT"),
      context()
      .withIdentifier(new QualifiedName<IdentifierName>(TypeScope.STATIC_SCOPE, "MY_CONSTANT", scope)));
  }
}