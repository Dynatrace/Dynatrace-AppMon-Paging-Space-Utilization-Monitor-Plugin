package wp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.dynatrace.diagnostics.pdk.Monitor;
import com.dynatrace.diagnostics.pdk.MonitorEnvironment;
import com.dynatrace.diagnostics.pdk.PluginEnvironment;
import com.dynatrace.diagnostics.pdk.Status;
import java.util.logging.Logger;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

public class pagingspaceutilization {

	private static final String CONFIG_PROCESS = "runningcommand";
	private static final String CONFIG_SERVER_USERNAME = "serverUsername";
	private static final String CONFIG_SERVER_PASSWORD = "serverPassword";
	private static final String CONFIG_METHOD = "method";
	private static final String CONFIG_AUTH_METHOD="authMethod";
	private static final String CONFIG_PASSPHRASE = "publickeyPassphrase";
	
	private boolean matchRuleSuccess;
	private String CMD = "ps -fu ";
	private String param = "root";
	private String server = null;
	private String param2 = " | ";
	private String param3 = "grep -s ";
	private String runningcommandName = null; 
	private String param4 = " | grep -v 'grep' | wc -l";
	private int count = 0;
	
	private String username = null;
	private String password = null;
	private String method = null;
	private String authMethod = null;
	private String runningcommand = null;
	private String host = null; 
	
	private static final Logger log = Logger.getLogger(pagingspaceutilization.class.getName());

	protected Status setup(PluginEnvironment env) throws Exception {
		Status result = new Status(Status.StatusCode.Success);
        String host = env.getHost().getAddress();
		String runningcommand = env.getConfigString(CONFIG_PROCESS);
		username = env.getConfigString(CONFIG_SERVER_USERNAME);
        method = env.getConfigString(CONFIG_METHOD) == null ? "SSH" : env
                .getConfigString(CONFIG_METHOD).toUpperCase();
        authMethod = env.getConfigString(CONFIG_AUTH_METHOD) == null ? "PASSWORD" : env
                .getConfigString(CONFIG_AUTH_METHOD).toUpperCase();
        password = (authMethod.equals("PUBLICKEY")) ? env.getConfigPassword(CONFIG_PASSPHRASE) : env.getConfigPassword(CONFIG_SERVER_PASSWORD);
        
			if (runningcommand != null && host != null) {
				server = host;
				// System.out.println(server);
				runningcommandName = runningcommand;
				// System.out.println(process);
			}
			
		return result;
	}

	protected Status execute(PluginEnvironment env) throws Exception {
		Status result = new Status(Status.StatusCode.Success);

		count = executeCommand(CMD, param, param2, param3, runningcommandName, param4, result);

		if (log.isLoggable(Level.FINE)) log.fine("Command output was: " + count);
		matchRuleSuccess = false;
		
//		if (count > 0) {
//			count = output.split(processName).length -1;
				result.setMessage("runningcommand Count is: " + count);
				matchRuleSuccess = true;
//		}
//		else {
//			    result = new Status(Status.StatusCode.PartialSuccess);
//				result.setMessage("0");
//				matchRuleSuccess = false;
//			}
		
//		System.out.println("Here's the process count: " + count);
		return result;
		
	}
	
	protected boolean isMatchRuleSuccess() {
		return matchRuleSuccess;
	}

	protected int returnPercentUsage() {
		return count;
	}
	protected void teardown(PluginEnvironment env) throws Exception {
	}

	private int executeCommand(String CMD, String param, String param2, String param3, String runningcommand, String param4, Status status) {
		
		String[] command = {"lsps -s |grep MB|awk '{print $2}'| cut -f 1 -d %"};
		
		String hostname = server;
		String inputstream = "";
		String line = "";
		// System.out.println(Arrays.toString(command));
		
		try {
			Connection conn = new Connection(hostname);
			conn.connect();
			boolean isAuthenticated = conn.authenticateWithPassword(username, password);

			Session sess = conn.openSession();

			sess.execCommand("lsps -s |grep MB|awk '{print $2}'| cut -f 1 -d %");

	//		InputStream stdout = new StreamGobbler(sess.getStdout());

	//		BufferedReader br = new BufferedReader(new InputStreamReader(stdout));

			BufferedReader br = new BufferedReader(new InputStreamReader(sess.getStdout()));

			line = br.readLine();
	//		System.out.println(line);

			sess.close();

			conn.close();
		}
		catch (IOException e) {
			e.printStackTrace(System.err);
			// System.exit(2);
		}
		// return inputstream;
		//return line;
		line = line.trim();
		return Integer.parseInt(line);



	}
	
}
