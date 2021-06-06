FROM tiangolo/uvicorn-gunicorn-fastapi:python3.7

ENV APP_HOME /app
WORKDIR $APP_HOME
COPY . ./

RUN pip3 install -r requirements.txt

CMD exec gunicorn --bind :$PORT --workers 1 --worker-class uvicorn.workers.UvicornWorker  --threads 8 app:app
