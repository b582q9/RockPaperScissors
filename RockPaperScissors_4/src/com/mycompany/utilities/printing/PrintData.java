package com.mycompany.utilities.printing;

import java.lang.System.Logger.Level;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @since 11 июня 2019 г. 01:34:55
 * @version 0.1
 */
public class PrintData implements Print<String,Throwable>{

    /**
     *
     * @param results
     */
    @Override
    public void results(Map<?,?> results){
        results.forEach((n,m)->System.out.println(n+":"+m));
    }

    /**
     *
     * @param message
     */
    @Override
    public void help(Optional<String> message){
        System.out.printf(Locale.US,"%1$s%n%n",message.orElse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE' 'd'-'LLLL'-'u' 'HH':'mm':'ss",Locale.US))));
        System.out.printf(Locale.US,"%1$s%n%2$s%n%3$s%n%4$s%n%5$s%n%6$s%n%7$s%n",
                "- For \"Rock\" (press 1, r or R)",
                "- For \"Paper\" (press 2, p or P)",
                "- For \"Scissors\" (press 3, s or S)",
                "- To view game statistic (press 4, v or V)",
                "- How to play (press 5, h or H)",
                "- Any other key for exit",
                "****************************************");
    }    

    /**
     *
     * @param err
     */
    @Override
    public void errors(Throwable err){
        System.getLogger(PrintData.class.getName()).log(Level.ALL,null,null,err);
        System.err.printf("$s%n",err);
    }
}
