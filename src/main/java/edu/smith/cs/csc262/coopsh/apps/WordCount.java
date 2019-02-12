package edu.smith.cs.csc262.coopsh.apps;

import edu.smith.cs.csc262.coopsh.InputLine;
import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;

public class WordCount extends Task {
	int wordCount = 0;
	int byteCount = 0;
	int lineCount = 0;

	public WordCount(ShellEnvironment env, String[] args) {
		super(env, args);
	}

	@Override
	protected void update() {
		InputLine line = this.input.poll();
		if (line == null) {
			// still waiting for more...
			return;
		}
		
		// only output and print when we've seen the whole file!
		if (line.isEndOfFile()) {
			this.println(wordCount);
			this.println(byteCount);
			this.println(lineCount);
			this.closeOutput();
			this.exit(0);
			return;
		}
		
		// Otherwise, increment this count!
		byteCount += line.get().length();
		wordCount += line.get().split("\\s+").length;
		lineCount ++;
	}
	
}
