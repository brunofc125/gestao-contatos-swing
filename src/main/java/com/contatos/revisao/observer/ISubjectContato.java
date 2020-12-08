package com.contatos.revisao.observer;

public interface ISubjectContato {

    public void attachObserver(IObserverContato observer);
    public void detachObserver(IObserverContato observer);
    public void notifyObservers();
    
}
