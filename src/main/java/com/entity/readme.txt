Entity实体类
************************************************************************************************

功能介绍：
数据库的每个数据表，分别对应一个entity实体类，每个实体类;
因为使用了hibernate，所以每个entity都对应一个*.hbm.xml配置文件。
*.hbm.xml配置文件的作用是将数据表的每个属性（也就是每一列）与entity实体类的每一个属性对应起来，
参见*.hbm.xml的<property>标签。

************************************************************************************************

编码任务：
entity实体类均由hibernate自动生成，不需要手动编码。

************************************************************************************************