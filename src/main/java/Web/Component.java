package Web;

import org.openqa.selenium.WebDriver;

/**
 * Created by Admin on 10-May-17.
 */
public abstract class Component<T extends Component<T>> {

    protected WebDriver driver;

    public Component(WebDriver driver){
        this.driver = driver;
    }

    public abstract boolean isAvailable();

    public T waitUntilAvailable(){
        return new Wait<T>().forComponent((T) this).toBeAvailabdle();
    }

}
