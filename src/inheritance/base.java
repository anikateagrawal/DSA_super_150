package inheritance;

import java.io.IOException;

public class base {
    protected Number fun()throws Exception {
        return 10;
    }
}
class derived extends base{
    @Override
    public Integer fun()throws Exception{
        return 20;
    }

}



