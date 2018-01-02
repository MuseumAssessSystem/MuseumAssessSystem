DAO层
**********************************************************************************************

功能介绍：
DAO层是数据访问层，具体来说就是数据的增删改查。
除DAO层以外，其它层都没有操作数据库的权限，
也就是说，sql命令只在DAO层才有，
其它层若需要使用数据库中的数据，只能通过调用DAO层的方法来得到数据。

**********************************************************************************************

编码任务：
每个实体entity对应一个DAO接口类和DAO接口实现类，举例来说：
UserEntity.java -- UserDAO.java -- UserDAOImpl.java

DAO类中的方法包括：
boolean Add*Entity(*Entity **);
boolean Delete*Entity(*Entity **);
boolean update*Entity(*Entity **);
以及各种搜索方法（根据功能需求确定搜索键值和方法返回值），如：
List<*Entity> get*Entity(String key);