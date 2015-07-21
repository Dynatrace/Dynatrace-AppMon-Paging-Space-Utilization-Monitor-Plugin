## Paging Space Utilization Monitor Plugin

The monitor returns the percent usage of the paging space via the command below on AIX servers. The command is specific to AIX. The user credentials entered when configuring the monitor must have ssh access to the remote server you wish to monitor.

This monitor is hard coded to run

    
    
    "lsps -s | grep MB| awk '{print $2}'| cut -f 1 -d %"

Find further information in the [dynaTrace community](https://community.dynatrace.com/community/display/DL/Paging+Space+Utilization+Monitor+Plugin)

