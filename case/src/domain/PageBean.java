package domain;

import java.util.List;

/**
 * @author KuiLian
 * @date 2020/6/14 - 1:14
 */
public class PageBean<T> {
    private int totalCount;//�ܼ�¼��

    private int totalPage;//��ҳ����
    private List<T> list;//ÿҳ������list����
    private int currentPage;//��ǰҳ��
    private int rows;//ÿҳ��ʾ������

    public List<T> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                '}';
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }



    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
