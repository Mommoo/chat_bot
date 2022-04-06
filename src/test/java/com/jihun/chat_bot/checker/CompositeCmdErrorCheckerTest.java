package com.jihun.chat_bot.checker;

import com.jihun.chat_bot.checker.cmd.CalCmdChecker;
import com.jihun.chat_bot.checker.cmd.CmdErrorChecker;
import com.jihun.chat_bot.checker.cmd.CompositeCmdErrorChecker;
import com.jihun.chat_bot.checker.cmd.DateCmdChecker;
import com.jihun.chat_bot.checker.cmd.FileCmdChecker;
import com.jihun.chat_bot.checker.cmd.SystemCmdChecker;
import java.util.List;
import org.junit.jupiter.api.Test;

class CompositeCmdErrorCheckerTest {
    @Test
    void temp() {

        CmdErrorChecker cmdErrorChecker = new CompositeCmdErrorChecker(
            List.of(new SystemCmdChecker(),
                    new FileCmdChecker(),
                    new CalCmdChecker(),
                    new DateCmdChecker())
        );

        String _input = "Data exit";
        String[] input = _input.split(" ");


        if (cmdErrorChecker.isNotSupport(input[0])) {
            String errorMessage = cmdErrorChecker.createErrorMessage(input[0]);

            System.out.println(errorMessage);
        }
    }
}
