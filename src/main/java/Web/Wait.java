package Web;


import org.openqa.selenium.TimeoutException;

public class Wait<T extends Component<T>> {

    private static final int DEFAULT_TIMEOUT = 30000;
    private static final int DEFAULT_TIME_DELAY = 500;
    private T component;


    public Wait(){}

    public Wait<T> forComponent(T component){
        this.component = component;
        return this;
    }

    public T toBeAvailabdle(){
        int timePassed = 0;
        while (timePassed < DEFAULT_TIMEOUT) {
            if (this.component.isAvailable()){
                return this.component;
            }
            timePassed = timePassed + delay();
        }
        if (!this.component.isAvailable()){
            throw new TimeoutException( this.component.getClass().getSimpleName() + " was not available during " + DEFAULT_TIMEOUT + "ms.");
        }
        return this.component;
    }

    private int delay(){
        try{
            Thread.sleep(DEFAULT_TIME_DELAY);
            return DEFAULT_TIME_DELAY;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }


}
