public class Test {
    private OnDoneListener<String> callback;

    public Test(OnDoneListener<String> callback){
        this.callback = callback;
    }

    public void execute() {
        callback.onDone("complete");
    }
}
