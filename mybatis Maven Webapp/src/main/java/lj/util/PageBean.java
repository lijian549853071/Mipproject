package lj.util;

public class PageBean {
	//开始数  
    private Integer startNumber;  
    //结束数  
    private Integer endNumber;  
      
    public PageBean(){  
          
    }  
    public PageBean(Integer startNumber, Integer endNumber) {  
        super();  
        this.startNumber = startNumber;  
        this.endNumber = endNumber;  
    }  
    public Integer getStartNumber() {  
        return startNumber;  
    }  
    public void setStartNumber(Integer startNumber) {  
        this.startNumber = startNumber;  
    }  
    public Integer getEndNumber() {  
        return endNumber;  
    }  
    public void setEndNumber(Integer endNumber) {  
        this.endNumber = endNumber;  
    }  
}
