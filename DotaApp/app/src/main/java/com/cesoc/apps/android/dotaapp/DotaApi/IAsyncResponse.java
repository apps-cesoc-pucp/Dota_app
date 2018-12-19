package com.cesoc.apps.android.dotaapp.DotaApi;

public interface IAsyncResponse {
    // delegado por AsyncTask.onPostExecute()
    // implementacion en una Activity, recibe un JSON string
    // obtenido de una URL pasada por AsyncTask.execute(URL)
    void processFinish(String jsonString);
}
