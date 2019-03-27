package lint;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.LiteralTree;
import org.sonar.plugins.java.api.tree.MethodInvocationTree;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.Arrays;
import java.util.List;

@Rule(key = "MyFirstCustomRule")
public class AMVCheck extends BaseTreeVisitor implements JavaFileScanner {

    private JavaFileScannerContext context;
    private static final String annotationName = "lint.AnimalMineralVegetable";
    private String[] amvArguments = {"animal", "mineral", "vegetable"};
    @Override
    public void visitMethodInvocation(MethodInvocationTree tree) {
        if( tree.symbol().metadata().isAnnotatedWith("lint.AnimalMineralVegetable")) {
            if (tree.arguments().size() != 1) {
                context.reportIssue(this, tree, "AMV Methods must have one and only one argument");
            } else {
                var argument = tree.arguments().get(0);
                if (argument.is(Tree.Kind.STRING_LITERAL)) {
                    //is string literal
                    if (!Arrays.stream(amvArguments).anyMatch((amv) -> argument.firstToken().text().equalsIgnoreCase("\""+amv+"\""))) {
                        context.reportIssue(this, tree, "AMV only accepts one of " + amvArguments);
                    }
                } else {
                    System.out.println("Not literal");
                }
            }
        }
    }

    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }
}

