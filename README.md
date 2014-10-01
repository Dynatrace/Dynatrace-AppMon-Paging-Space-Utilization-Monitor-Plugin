<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Paging Space Utilization Monitor Plugin</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
    <meta content="Scroll Wiki Publisher" name="generator"/>
    <link type="text/css" rel="stylesheet" href="css/blueprint/liquid.css" media="screen, projection"/>
    <link type="text/css" rel="stylesheet" href="css/blueprint/print.css" media="print"/>
    <link type="text/css" rel="stylesheet" href="css/content-style.css" media="screen, projection, print"/>
    <link type="text/css" rel="stylesheet" href="css/screen.css" media="screen, projection"/>
    <link type="text/css" rel="stylesheet" href="css/print.css" media="print"/>
</head>
<body>
                <h1>Paging Space Utilization Monitor Plugin</h1>
    <div class="section-2"  id="114557272_PagingSpaceUtilizationMonitorPlugin-Overview"  >
        <h2>Overview</h2>
    <p>
The monitor returns the percent usage of the paging space via the command below on AIX servers. The command is specific to AIX. The user credentials entered when configuring the monitor must have ssh access to the remote server you wish to monitor.    </p>
    <p>
This monitor is hard coded to run    </p>
    <div class="confbox programlisting">
                <div class="content">
        <pre><code>&quot;lsps -s | grep MB| awk '{print $2}'| cut -f 1 -d %&quot;</code></pre>
        </div>
    </div>
    <p>
    </p>
    <div class="tablewrap">
        <table>
<thead class=" "></thead><tfoot class=" "></tfoot><tbody class=" ">    <tr>
            <td rowspan="1" colspan="1">
        <p>
            <img src="images_community/download/attachments/114557272/Paging_Space_Utilization_Settings.jpg" alt="images_community/download/attachments/114557272/Paging_Space_Utilization_Settings.jpg" class="" />
            </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
            <img src="images_community/download/attachments/114557272/Paging_Space_Utilization_Measure.jpg" alt="images_community/download/attachments/114557272/Paging_Space_Utilization_Measure.jpg" class="" />
            </p>
            </td>
        </tr>
    <tr>
            <td rowspan="1" colspan="1">
                </td>
                <td rowspan="1" colspan="1">
                </td>
        </tr>
</tbody>        </table>
            </div>
    </div>
    <div class="section-2"  id="114557272_PagingSpaceUtilizationMonitorPlugin-PluginDetails"  >
        <h2>Plugin Details</h2>
    <div class="tablewrap">
        <table>
<thead class=" "></thead><tfoot class=" "></tfoot><tbody class=" ">    <tr>
            <td rowspan="1" colspan="1">
        <p>
Plug-In Versions    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
<a href="attachments_114688044_1_com.dynatrace.diagnostics.plugins.PagingSpaceUtilizationPlugin_1.0.1.jar">Paging Space Utilization Monitor Plugin 1.0.1</a> (compatible with dynaTrace 4.2+)    </p>
            </td>
        </tr>
    <tr>
            <td rowspan="1" colspan="1">
        <p>
Author    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
Derek Abing    </p>
            </td>
        </tr>
    <tr>
            <td rowspan="1" colspan="1">
        <p>
License    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
<a href="attachments_5275722_2_dynaTraceBSD.txt">dynaTrace BSD</a>    </p>
            </td>
        </tr>
    <tr>
            <td rowspan="1" colspan="1">
        <p>
Support    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
<a href="https://community/display/DL/Support+Levels#SupportLevels-Community">Not Supported </a><br/>If you have any questions or suggestions for these plugins, please add a comment to this page, use our <a href="https://community.dynatrace.com/community/pages/viewpage.action?pageId=46628918">forum</a>, or drop us an email at <a href="mailto:apmcommunity@compuware.com">apmcommunity@compuware.com</a>!    </p>
            </td>
        </tr>
    <tr>
            <td rowspan="1" colspan="1">
        <p>
Known Problems    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
    </p>
            </td>
        </tr>
    <tr>
            <td rowspan="1" colspan="1">
        <p>
Release History    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
2013-03-12 Initial Release    </p>
            </td>
        </tr>
</tbody>        </table>
            </div>
    </div>
    <div class="section-2"  id="114557272_PagingSpaceUtilizationMonitorPlugin-ProvidedMeasures"  >
        <h2>Provided Measures</h2>
    <p>
<strong class=" ">PercentUsage</strong>: Returns count of running processes    </p>
    </div>
    <div class="section-2"  id="114557272_PagingSpaceUtilizationMonitorPlugin-Configuration"  >
        <h2>Configuration</h2>
    <div class="tablewrap">
        <table>
<thead class=" ">    <tr>
            <td rowspan="1" colspan="1">
        <p>
Name    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
Value    </p>
            </td>
        </tr>
</thead><tfoot class=" "></tfoot><tbody class=" ">    <tr>
            <td rowspan="1" colspan="1">
        <p>
Running Command    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
This monitor is hard coded to run &quot;lsps -s | grep MB| awk '{print $2}'| cut -f 1 -d %&quot;    </p>
            </td>
        </tr>
    <tr>
            <td rowspan="1" colspan="1">
        <p>
Username    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
The username that is used for authorization with the host    </p>
            </td>
        </tr>
    <tr>
            <td rowspan="1" colspan="1">
        <p>
Password    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
The password for the username    </p>
            </td>
        </tr>
</tbody>        </table>
            </div>
    </div>
    <div class="section-2"  id="114557272_PagingSpaceUtilizationMonitorPlugin-Installation"  >
        <h2>Installation</h2>
    <p>
Import the Plugin into the dynaTrace Server. For details how to do this please refer to the <a href="https://community.dynatrace.com/community/display/DOCDT50/Manage+and+Develop+Plugins#ManageandDevelopPlugins-ManageandDevelopPlugins">dynaTrace  documentation</a>.    </p>
    </div>
            </div>
        </div>
        <div class="footer">
        </div>
    </div>
</body>
</html>
