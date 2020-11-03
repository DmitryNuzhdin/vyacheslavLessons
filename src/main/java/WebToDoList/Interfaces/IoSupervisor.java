package WebToDoList.Interfaces;

import java.util.List;

public class IoSupervisor {
    List<IMyInterface> myInterfaces;

    public IoSupervisor(List<IMyInterface> myInterfaces) {
        this.myInterfaces = myInterfaces;
    }

    public void startAll(){
        myInterfaces.forEach(IMyInterface::start);
    }
}
