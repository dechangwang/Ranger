package cn.edu.tongji.ranger.utils;

public class ReturnPageWrapper<T> extends ReturnWrapper<T> {

    private int numPerPage;
    private int currPageNum;
    private int totalItemNum;

    public ReturnPageWrapper() {
        super();
    }

    public int getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }

    public int getCurrPageNum() {
        return currPageNum;
    }

    public void setCurrPageNum(int currPageNum) {
        this.currPageNum = currPageNum;
    }

    public int getTotalItemNum() {
        return totalItemNum;
    }

    public void setTotalItemNum(int totalItemNum) {
        this.totalItemNum = totalItemNum;
    }

    public int getTotalPageNum() {
        if(totalItemNum % numPerPage == 0)
            return totalItemNum / numPerPage;
        else
            return totalItemNum / numPerPage + 1;
    }

}
