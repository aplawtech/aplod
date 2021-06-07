![logo fix no ellipse](https://user-images.githubusercontent.com/55023518/121027586-4a164d80-c7d1-11eb-9432-63b89e9af274.png)

# Bangkit 2021 Capstone Team : B21-CAP0036 

Hellow. Here is our repository for Bangkit 2021 Capstone project. Our team consist of 2 Machine Learning, 2 Android, and 2 Cloud Computing.
 

## Our Knights : Law's Tech

|          Nama         | Bangkit-ID |       Path       |
|:---------------------:|:----------:|:----------------:|
|  Muhammad Bondan V.R  |  M0040231  | Machine Learning |
|  Muhammad Ikhwan K.N  |  M0121267  | Machine Learning |
|   Adimas Fachri R.    |  C0121288  |  Cloud Computing |
|  Agnesia Indryany M.  |  C0121278  |  Cloud Computing |
|    Alex Lianardo      |  A0121283  |      Android     |
|    Annisaa Utami      |  A2242180  |      Android     |

## What is this project
We make a mobile application named APLOD (Aman Pesannya Let’s gO uploaD). APLOD is a hate speech comment detector application integrated with ITE Law. With this application, everyone can check whether a sentence contains harmful words that can violate ITE Law before uploading it to social media. We want to reduce hate comments made by Indonesian people on social media platforms such as Twitter, Instagram, etc. Hate comments not only can hurt someone but also can lead to ITE Law violation.

## Tech Stack

![stack](https://user-images.githubusercontent.com/55023518/121032474-7fbd3580-c7d5-11eb-9b0a-7c7ed74f8a46.jpg)


## Local Deployment Machine Learning Jupyter Notebook
Make sure you intalled all this dependencies first on your local machine. You can use conda virtual env for making things easier with pip
```text
sklearn==0.24.2 
fastapi==‎0.64.0 
pandas==1.2.4
pydantic==0.28
tensorflow==2.3.0
uvicorn==0.8.6
h5py==2.10.0
python-multipart==0.0.5
numpy==1.18.0
```

For using our NLP Model, You must clone our repository first with this following command :

`git clone https://github.com/aplawtech/aplod.git`

after cloning the repository, go to the aplod directory and run the following command on your favorite CLI (make sure you are in /aplod directory) :

` uvicorn app:app --host=0.0.0.0 --port=${PORT:-5000} `

We already provide you all of the data set and NLP model, so you just need to run the command above



## Project Update

**TBD** 
