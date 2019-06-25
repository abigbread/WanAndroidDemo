package com.wan.bread.wanandroid.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by spp on 2019/4/10 0010.
 *
 * 收藏文章
 *
 */

public class CollectArticleBean {

    /**
     * curPage : 1
     * datas : [{"author":"xchengDroid","chapterId":358,"chapterName":"项目基础功能","courseId":13,"desc":"支持全局取消请求，监听请求开始、结束、取消、成功、失败、下载进度等。不依赖除Retrofit外任何第三方库","envelopePic":"http://www.wanandroid.com/resources/image/pc/default_project_img.jpg","id":46808,"link":"http://www.wanandroid.com/blog/show/2430","niceDate":"2019-02-18","origin":"","originId":7556,"publishTime":1550470829000,"title":"Retrofit 最简洁的封装","userId":16779,"visible":0,"zan":0},{"author":"yangchong211","chapterId":358,"chapterName":"项目基础功能","courseId":13,"desc":"轻量级版本更新弹窗，弹窗上支持更新进度条，可以设置普通更新或者强制更新。解决8.0以上通知栏不显示问题，解决7.0以上安装apk异常，下载完成则会自动提示安装；下载异常，失败，错误等状态，支持重启下载任务；还支持自定义下载路径。代码量少，调用简单&hellip;&hellip; ","envelopePic":"http://wanandroid.com/blogimgs/1f50bc2f-12c2-4bfd-87d2-53102913a06b.png","id":46790,"link":"http://www.wanandroid.com/blog/show/2437","niceDate":"2019-02-18","origin":"","originId":7573,"publishTime":1550461499000,"title":"轻量级版本更新弹窗 YCUpdateApp","userId":16779,"visible":0,"zan":0},{"author":"xuehuayous","chapterId":314,"chapterName":"RV列表动效","courseId":13,"desc":"一种优雅的方式来使用RecyclerView，把你从复杂的多类型多样式中解放出来！","envelopePic":"http://wanandroid.com/blogimgs/1d6ed12c-1507-4826-878a-3737dff82daa.png","id":46784,"link":"http://www.wanandroid.com/blog/show/2439","niceDate":"2019-02-18","origin":"","originId":7592,"publishTime":1550461174000,"title":"一种优雅的方式来使用RecyclerView","userId":16779,"visible":0,"zan":0},{"author":"wenjiangit","chapterId":358,"chapterName":"项目基础功能","courseId":13,"desc":"支持自动无限轮播，无需手动开启和关闭，无需担心内存泄漏\r\n支持页面内容完全自定义\r\n支持自定义页面点击事件\r\n支持自定义指示器样式","envelopePic":"http://wanandroid.com/blogimgs/261666d8-ea7c-4aee-b854-52d78e04f548.png","id":46768,"link":"http://www.wanandroid.com/blog/show/2472","niceDate":"2019-02-18","origin":"","originId":7731,"publishTime":1550455460000,"title":"一个简单好用的自动轮播控件,支持UI风格完全自定义","userId":16779,"visible":0,"zan":0},{"author":"wuyr","chapterId":323,"chapterName":"动画","courseId":13,"desc":"扩展自QQ空间的列表Header效果~","envelopePic":"http://www.wanandroid.com/blogimgs/17469897-ed82-4fc0-9a00-89164e0c3c74.png","id":46765,"link":"http://www.wanandroid.com/blog/show/2497","niceDate":"2019-02-18","origin":"","originId":7940,"publishTime":1550454854000,"title":"RandomDragLayout (任意拖布局)","userId":16779,"visible":0,"zan":0}]
     * offset : 0
     * over : true
     * pageCount : 1
     * size : 20
     * total : 5
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    @SerializedName("datas")
    private List<DataBean> data;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setDatas(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * author : xchengDroid
         * chapterId : 358
         * chapterName : 项目基础功能
         * courseId : 13
         * desc : 支持全局取消请求，监听请求开始、结束、取消、成功、失败、下载进度等。不依赖除Retrofit外任何第三方库
         * envelopePic : http://www.wanandroid.com/resources/image/pc/default_project_img.jpg
         * id : 46808
         * link : http://www.wanandroid.com/blog/show/2430
         * niceDate : 2019-02-18
         * origin :
         * originId : 7556
         * publishTime : 1550470829000
         * title : Retrofit 最简洁的封装
         * userId : 16779
         * visible : 0
         * zan : 0
         */

        private String author;
        private int chapterId;
        private String chapterName;
        private int courseId;
        private String desc;
        private String envelopePic;
        private int id;
        private String link;
        private String niceDate;
        private String origin;
        private int originId;
        private long publishTime;
        private String title;
        private int userId;
        private int visible;
        private int zan;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getEnvelopePic() {
            return envelopePic;
        }

        public void setEnvelopePic(String envelopePic) {
            this.envelopePic = envelopePic;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getNiceDate() {
            return niceDate;
        }

        public void setNiceDate(String niceDate) {
            this.niceDate = niceDate;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public int getOriginId() {
            return originId;
        }

        public void setOriginId(int originId) {
            this.originId = originId;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }

        public int getZan() {
            return zan;
        }

        public void setZan(int zan) {
            this.zan = zan;
        }
    }
}
