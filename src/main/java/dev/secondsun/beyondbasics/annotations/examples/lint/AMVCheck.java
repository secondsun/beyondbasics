package dev.secondsun.beyondbasics.annotations.examples.lint;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;
import com.puppycrawl.tools.checkstyle.checks.sizes.MethodCountCheck;

public class AMVCheck extends AbstractCheck {

    @Override
    public int[] getDefaultTokens() {
        return new int[]{TokenTypes.METHOD_CALL};
    }

    @Override
    public void visitToken(DetailAST ast) {
        MethodCountCheck
    }
}
