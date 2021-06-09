import numpy as np
from fastapi import FastAPI, Form
import pandas as pd
from starlette.responses import HTMLResponse 
from tensorflow.keras.preprocessing.text import Tokenizer
from tensorflow.keras.preprocessing.sequence import pad_sequences
import tensorflow as tf
import string
import re

def preProcess_data(text):

    
    #cleaning the data

    text = text.lower()
    new_text = re.sub('[^a-zA-z0-9\s]','',text)
    new_text = re.sub('rt', '', new_text)
    #Hapus Tanda Baca
    remove = string.punctuation
    translator = str.maketrans(remove, ' '*len(remove))
    new_text = new_text.translate(translator)
    #hapus ASCII dan UNICODE
    new_text = new_text.encode('ascii', 'ignore').decode('utf-8')
    new_text = re.sub(r'[^\x00-\x7f]','r',new_text)
    #remove newline
    new_text = new_text.replace('\n', ' ')

    return new_text

app = FastAPI()

data = pd.read_csv('dataset/dataset.csv')
tokenizer = Tokenizer(num_words=2000, split=' ')
tokenizer.fit_on_texts(data['Sentences'].values)



def my_pipeline(text): #pipeline
  text_new = preProcess_data(text)
  X = tokenizer.texts_to_sequences(pd.Series(text_new).values)
  X = pad_sequences(X, maxlen=28)
  return X


@app.get('/') #basic get view
def basic_view():
    return {"WELCOME": "GO TO /docs route, or /post or send post request to /predict "}



@app.get('/predict', response_class=HTMLResponse) #data input by forms
def take_inp():
    return '''<form method="post"> 
    <h1>APLOD sentiment analysis model</h1>
    <input type="text" maxlength="28" name="text" value=""/>  
    <input type="submit"/> 
    <h2>Our Knights</h2>
    <h3>Muhammad Bondan Vitto Ramadhan (M0040231) - Machine Learning - Institut Teknologi Sepuluh Nopember</h3>
    <h3>Muhammad Ikhwan Khalid Nasution (M0121267) - Machine Learning - Universitas Telkom</h3>
    <h3>Adimas Fachri Ranunegoro (C0121288) - Cloud Computing - Universitas Telkom</h3>
    <h3>Agnesia Indryany Mangopo (C0121278) - Cloud Computing - Universitas Telkom</h3>
    <h3>Annisaa Utami (A2242180) - Mobile Programming (Android) - Universitas Islam Negeri Syarif Hidayatullah</h3>
    <h3>Alex Lianardo (A0121283) - Mobile Programming (Android) - Universitas Telkom</h3>
    
    </form>'''



@app.post('/predict') #prediction on data
def predict(text:str = Form(...)): #input is from forms
    clean_text = my_pipeline(text) #cleaning and preprocessing of the texts
    loaded_model = tf.keras.models.load_model('model/aplod_version_2.h5') #loading the saved model
    predictions = loaded_model.predict(clean_text) #making predictions
    sentiment = int(np.argmax(predictions)) #index of maximum prediction
    probability = max(predictions.tolist()[0]) #probability of maximum prediction
    if sentiment==0: #assigning appropriate name to prediction
        t_sentiment = 'Negatif'
    elif sentiment==1:
        t_sentiment = 'Positif'
    
    return { #returning a dictionary as endpoint
        "Kalimat": text,
        "Sentimen": t_sentiment,
        "Hasil": probability
    }
