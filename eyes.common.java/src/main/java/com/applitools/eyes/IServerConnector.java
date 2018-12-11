package com.applitools.eyes;

import java.net.URI;
import java.net.URL;

/**
 * Defines the interface which should be implemented by a ServerConnector.
 */
public interface IServerConnector {
    void setApiKey(String apiKey);
    String getApiKey();

    void setServerUrl(URI serverUrl);
    URI getServerUrl();

    void setLogger(Logger logger);
    Logger getLogger();


    void setProxy(AbstractProxySettings abstractProxySettings);
    AbstractProxySettings getProxy();

    /**
     *
     * @return The server timeout. (Seconds).
     */
    int getTimeout();

    /**
     * Starts a new running session in the agent. Based on the given parameters,
     * this running session will either be linked to an existing session, or to
     * a completely new session.
     *
     * @param sessionStartInfo The start parameters for the session.
     * @return RunningSession object which represents the current running
     *         session
     * @throws EyesException the exception is being thrown when start session failed
     */
    RunningSession startSession(SessionStartInfo sessionStartInfo);

    /**
     * Stops the running session.
     *
     * @param runningSession The running session to be stopped.
     * @param isAborted Indicates that the session is being aborted
     * @param save Indicates whether the server should update the baseline.
     * @return TestResults object for the stopped running session
     * @throws EyesException the exception is being thrown when stopSession failed
     */
    TestResults stopSession(final RunningSession runningSession,
                                   final boolean isAborted, final boolean save);

    /**
     * Deletes the given test result
     *
     * @param testResults The session to delete by test results.
     * @throws EyesException the exception is being thrown when deleteSession failed
     */
    void deleteSession(TestResults testResults);

    /**
     * Matches the current window (held by the WebDriver) to the expected
     * window.
     *
     * @param runningSession The current agent's running session.
     * @param matchData Encapsulation of a capture taken from the application.
     * @return The results of the window matching.
     * @throws EyesException the exception is being thrown when deleteSession matchWindow
     */
    MatchResult matchWindow(RunningSession runningSession,
                            MatchWindowData matchData);

    /**
     * Downloads string from a given Url
     *
     * @param uri The URI from which the IServerConnector will download the string
     * @param isSecondRetry Indicates if a retry is mandatory onFailed - 2 retries per request
     * @param listener the listener will be called when the request will be resolved.
     */
    void downloadString(URL uri, boolean isSecondRetry, IDownloadListener listener);


    String postDomSnapshot(String domJson);
}
