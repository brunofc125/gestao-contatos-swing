package com.contatos.revisao.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public abstract class BaseService<T, I> {

    public T insert(T source, Class<T> clazz) throws Exception {
        URL url = new URL("https://gestao-contatos-pss.herokuapp.com/gestao-contatos/contatos");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        try {
            Gson gson = new Gson();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            try ( OutputStream os = conn.getOutputStream()) {

                byte[] input = gson.toJson(source).getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            StringBuilder response = new StringBuilder();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                try ( BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "utf-8"))) {
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                }
                throw new RuntimeException(response.toString());
            } else {
                try ( BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                }
            }

            return gson.fromJson(response.toString(), clazz);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception("Erro ao inserir");
        } finally {
            conn.disconnect();
        }
    }

    public T update(T source, Class<T> clazz) throws Exception {
        URL url = new URL("https://gestao-contatos-pss.herokuapp.com/gestao-contatos/contatos");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        try {
            Gson gson = new Gson();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            try ( OutputStream os = conn.getOutputStream()) {

                byte[] input = gson.toJson(source).getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            StringBuilder response = new StringBuilder();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                try ( BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "utf-8"))) {
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                }
                throw new RuntimeException(response.toString());
            } else {
                try ( BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                }
            }

            return gson.fromJson(response.toString(), clazz);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception("Erro ao atualizar");
        } finally {
            conn.disconnect();
        }
    }
    
    public T get(I id, Class<T> clazz) throws Exception {
        URL url = new URL("https://gestao-contatos-pss.herokuapp.com/gestao-contatos/contatos/" + id);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        try {
            Gson gson = new Gson();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            StringBuilder response = new StringBuilder();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                try ( BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "utf-8"))) {
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                }
                throw new RuntimeException(response.toString());
            } else {
                try ( BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                }
            }

            return gson.fromJson(response.toString(), clazz);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception("Erro ao atualizar");
        } finally {
            conn.disconnect();
        }
    }
    
    public List<T> getAll(Class<T> clazz) throws Exception {
        URL url = new URL("https://gestao-contatos-pss.herokuapp.com/gestao-contatos/contatos");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        try {
            Gson gson = new Gson();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            StringBuilder response = new StringBuilder();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                try ( BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "utf-8"))) {
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                }
                throw new RuntimeException(response.toString());
            } else {
                try ( BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                }
            }
            
            Type tipo = TypeToken.getParameterized(List.class, clazz).getType();
            
            return gson.fromJson(response.toString(), tipo);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception("Erro ao atualizar");
        } finally {
            conn.disconnect();
        }
    }
    
    public void delete(I id) throws Exception {
        URL url = new URL("https://gestao-contatos-pss.herokuapp.com/gestao-contatos/contatos/" + id);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        try {
            Gson gson = new Gson();
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            StringBuilder response = new StringBuilder();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                try ( BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "utf-8"))) {
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                }
                throw new RuntimeException(response.toString());
            } else {
                try ( BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                }
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception("Erro ao atualizar");
        } finally {
            conn.disconnect();
        }
    }

}
