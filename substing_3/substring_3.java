package substing_3;

public class substring_3 {
    public static int substring(String a, String b)throws NullPointerException{
        if(a==null || b==null){
            throw new NullPointerException();
        }
        int returnVale =1;
        int tmp=0;
        StringBuilder c = new StringBuilder(a);
        int counter =0;
        for(int i=0; i<c.length();i++){
            if(b.length()<c.length()){
                tmp = b.length();
            }
            if(b.startsWith(c.substring(0 ,tmp))){
                break;
            }
            c = new StringBuilder(c.substring(1));
        }
        c = new StringBuilder(c.substring(counter));
        if(c.toString().equals("")) return -1;
        do{
            if(c.toString().contains(b)){
                return returnVale;
            }
            if(b.length()<c.length()){
                return -1;
            }
            else {
                c.append(a);
                returnVale++;
            }
        }while(true);
    }

}
