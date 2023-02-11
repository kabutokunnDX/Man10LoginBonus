package kbtdx.man10loginbonus;

import org.bukkit.plugin.java.JavaPlugin;

public final class Man10LoginBonus extends JavaPlugin {

    public static JavaPlugin mlb;
    public static MySQLManager mysql;
    @Override
    public void onEnable() {
        mlb=this;
        getCommand("mlb").setExecutor(new Commands());
        mysql=new MySQLManager(mlb,"mlb_data");
        mysql.execute("create table if not exists mlb_data(id int auto_increment,mcid varchar(16),uuid varchar(36),login_days int,end_login varchar(10))");
    }

    @Override
    public void onDisable() {
    }
}
