package DB;

/**
 * Created by miaohualin on 2018/5/4.
 */
public class MysqlException extends Exception{//自定义异常类，因为继承了Exception类，所以成为了异常家族的一员
    public MysqlException(String msg){//构造函数，包含一条消息，此处我们简单的以消息内容区分不同的数据库异常
        super(msg);
    }
}
