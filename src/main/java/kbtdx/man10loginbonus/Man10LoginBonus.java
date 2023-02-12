package kbtdx.man10loginbonus;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Man10LoginBonus extends JavaPlugin {

    public static JavaPlugin mlb;
    public static MySQLManager mysql;
    @Override
    public void onEnable() {
        mlb=this;
        getCommand("mlb").setExecutor(new Commands());
        File file = new File(mlb.getDataFolder().getAbsolutePath() + File.separator + "bonuses");
        if (file.mkdir()){Bukkit.getLogger().info("ボーナスファイルを作成しました。");}else {Bukkit.getLogger().info("ボーナスファイルの作成に失敗しました。");}
        mysql=new MySQLManager(mlb,"mlb_data");
        mysql.execute("create table if not exists mlb_data(id int auto_increment,mcid varchar(16),uuid varchar(36),login_days int,end_login varchar(10))");
    }

    @Override
    public void onDisable() {
    }
}
