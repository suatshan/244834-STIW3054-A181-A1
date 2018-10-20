public class DataFile {

    private String result,result2;

    public DataFile()
    {
        super();
    }

    public DataFile(String result, String result2){
        this.result=result;
        this.result2=result2;

    }

    public void setResult(String result){
        this.result=result;
    }

    public String getResult(){

        return result;
    }

    public void setResult2(String result)
    {
        this.result2=result2;
    }

    public String getResult2(){

        return result2;
    }
}

