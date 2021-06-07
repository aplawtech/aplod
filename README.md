![logo fix no ellipse](https://user-images.githubusercontent.com/55023518/121027586-4a164d80-c7d1-11eb-9432-63b89e9af274.png)

# Bangkit 2021 Capstone Team : Law's Tech Team (B21-CAP0036)

Hellow. Here is our repository for Bangkit 2021 Capstone project. Our team consist of 2 Machine Learning, 2 Android, and 2 Cloud Computing.
 

## Our Knights

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

<img src="https://user-images.githubusercontent.com/55023518/121036560-09223700-c7d9-11eb-8462-714a6715c4c2.jpg" alt="Logo" width="250" height="550">&nbsp; &nbsp;
<img src="https://user-images.githubusercontent.com/55023518/121036798-26570580-c7d9-11eb-891a-bd822ba488c1.jpg" alt="Logo" width="250" height="550">&nbsp; &nbsp;
<img src="https://user-images.githubusercontent.com/55023518/121036879-35d64e80-c7d9-11eb-8867-a4da8ebecd6b.jpg" alt="Logo" width="250" height="550">&nbsp; &nbsp;



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

## Library Used in Android Application
1. [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview)
2. [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle)
3. [Glide](https://github.com/bumptech/glide)
4. [CircleImageView by hdodenhof](https://github.com/hdodenhof/CircleImageView)
5. [Retrofit 2](https://square.github.io/retrofit/)
6. [Material Design](https://material.io/develop/android)

## Fork Repository
In order to duplicate our repository to become your repository on your own github account, you need to **fork** this repository
![image](https://user-images.githubusercontent.com/85149518/120605441-405eb400-c478-11eb-9304-4dcd1fa61a71.png) </br>
Forking repository allows you to modificate this project without affecting the original project.

## Clone Repository
Download code from branch "main" **OR** 
2. Clone Repository. Click on dropdown Code and **copy** HTTPS link
2. Clone Repository. Click on dropdown Code and **copy** HTTPS link <br/>
![Image Copy HTTPS](https://camo.githubusercontent.com/1c0cf8056422ff414eee75142b213c5970e085c2e33c0a6d69dc2639d98216f1/68747470733a2f2f6669727374636f6e747269627574696f6e732e6769746875622e696f2f6173736574732f526561646d652f636f70792d746f2d636c6970626f6172642e706e67)
```
git clone https://github.com/aplawtech/aplod.git
```

### Next Step
1. Work on the project locally in your own computer
2. **Create new Branch** based on the feature you make using " git checkout -b <new_branch> " <br/>
Example :
```
git checkout -b layout-member
```
3. **Commit** changes to your branch. Don't forget to give proper commit message so other people can understand it <br/>
Example:
```
git commit -m "add layout-member"
```
4. **Push** to your branch <br/>
Example:
```
git push origin layout-member
```

## Project Update

**TBD** 
