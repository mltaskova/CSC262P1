package edu.smith.cs.csc262.coopsh.apps;

import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;

import java.io.File;
import java.util.Arrays;

/**
 * Created by mltaskova on 2/10/19.
 */
public class ListFiles extends Task {

    File workingDir;

    public ListFiles(ShellEnvironment env, String[] args) {
        super(env, args);
        this.workingDir = env.currentDirectory;
    }

    @Override
    protected void update() {
        if (workingDir.isDirectory()){
            for (String f : workingDir.list()) {
                this.println(f);
            }
        }
        this.closeOutput();
        this.exit(0);
    }
}
