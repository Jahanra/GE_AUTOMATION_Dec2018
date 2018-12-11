package rough;

public class tryContains
{
    public static void main(String[] args)
    {
     String str1="Alternative Lending";
     String str2="Fintech:Alternative Lending, Fintech:Crowdfunding";
     if(str2.contains(str1))
     {
         System.out.println("Passed");
     }
     else
     {
         System.out.println("Failed");
     }
    }
}
