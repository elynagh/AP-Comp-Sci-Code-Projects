import java.io.IOException;  
import java.util.Scanner;
public class Main
{
    public static void main(String [] args) throws IOException
    {
        Scanner scan = new Scanner(System.in); //set-up scanner
        //intializing variables start
        String cleanBad = "";
        String userName = "";
        
        //the curse words: ^^, qey, $, z
        int twoCarrots = 0;
        int qey = 0;
        int $ = 0;
        int z = 0;

        String messageBoardPost = scan.nextLine();
        String messageBoardPostLower = messageBoardPost.toLowerCase();
       
       //username set 
        while(z == 0){
            for (int i = 0; i < messageBoardPost.length(); i++){
            if((i+1)>messageBoardPost.length()){
                userName = messageBoardPost;
                z = 1;
            }
            else if(messageBoardPost.charAt(i) == ' '){
                userName = messageBoardPost.substring(0, i);
                z = 1;
                break;
            }
        }
        }
        
        
        //twoCarrot
        for(int i = 0; i < messageBoardPost.length(); i++){
            if((i+3) >=messageBoardPost.length()){
                if(messageBoardPost.charAt(i) == ' '){
            if(messageBoardPost.charAt(i+1) == '^'){
                if(messageBoardPost.charAt(i+2) == '^'){
                    twoCarrots++;
            }}}}
            else if(i == 0){
                if(messageBoardPost.charAt(i) == '^'){
                if(messageBoardPost.charAt(i+1) == '^'){
                    if(messageBoardPost.charAt(i+2) == ' '){
                        twoCarrots++;
                    }
            }}}
            else if(messageBoardPost.charAt(i) == ' '){
            if(messageBoardPost.charAt(i+1) == '^'){
                if(messageBoardPost.charAt(i+2) == '^'){
                    if(messageBoardPost.charAt(i+3) == ' '){
                        twoCarrots++;
                    }
                }
            }
        }
    }
        //qey
        for(int i = 0; i < messageBoardPostLower.length(); i++){
            if((i+4)>=messageBoardPost.length()){
                if(messageBoardPostLower.charAt(i) == ' '){
            if(messageBoardPostLower.charAt(i+1) == 'q'){
                if(messageBoardPostLower.charAt(i+2) == 'e'){
                    if(messageBoardPostLower.charAt(i+3) == 'y'){
                        qey++;
            }}}}}
            else if (i == 0){
                if(messageBoardPostLower.charAt(i) == 'q'){
                if(messageBoardPostLower.charAt(i+1) == 'e'){
                    if(messageBoardPostLower.charAt(i+2) == 'y'){
                        if(messageBoardPostLower.charAt(i+3) == ' '){
                        qey++;
            }}}}}
            else if(messageBoardPostLower.charAt(i) == ' '){
            if(messageBoardPostLower.charAt(i+1) == 'q'){
                if(messageBoardPostLower.charAt(i+2) == 'e'){
                    if(messageBoardPostLower.charAt(i+3) == 'y'){
                        if(messageBoardPostLower.charAt(i+4) == ' '){
                        qey++;
                    }}
                }
            }
            }
        }
        //$
        for(int i = 0; i < messageBoardPostLower.length(); i++){
            if((i+2)>=messageBoardPost.length()){
                if(messageBoardPostLower.charAt(i) == ' '){
            if(messageBoardPostLower.charAt(i+1) == '$'){
                $++;
            }}}
            else if(i == 0){
                if(messageBoardPostLower.charAt(i) == '$'){
                    if(messageBoardPostLower.charAt(i+1) == ' '){
                        $++;
            }}}
            else if(messageBoardPostLower.charAt(i) == ' '){
            if(messageBoardPostLower.charAt(i+1) == '$'){
                    if(messageBoardPostLower.charAt(i+2) == ' '){
                        $++;
                    }
            }
            }
        }
        
        //cleanBad
        if(twoCarrots > 0 || qey > 0 || $ > 0){
            cleanBad = "BAD";
        }
        else{
            cleanBad = "CLEAN";
        }
        
        //print statement
        if(twoCarrots <= 0 && qey <= 0 && $ <= 0){
            System.out.println("Results:\n" + cleanBad);
        }
        else{
            System.out.println("Results:\n" + cleanBad + "\n" + userName + "\n^^: " + twoCarrots + "\nqey: " + qey + "\n$: " + $);
        }
        
    }
    
}
