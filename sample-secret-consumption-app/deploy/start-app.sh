export MONGO_USER_NAME=$(python3 ~/openws/pycharmprojects/secret-loader-sdk/secret_loader.py get \
--env S \
--key-name mongodb.username \
--app-code vje \
--sub-app-code EDL \
--secrets-base-path /Users/singg/openws/pycharmprojects/secret-loader-sdk/secrets)

export MONGO_PASSWORD=$(python3 ~/openws/pycharmprojects/secret-loader-sdk/secret_loader.py get --env S --key-name mongodb.password --app-code vje --sub-app-code EDL --secrets-base-path /Users/singg/openws/pycharmprojects/secret-loader-sdk/secrets)

java -cp /Users/singg/openws/java/sample-secret-consumption-app/target/sample-secret-consumption-app-1.0-SNAPSHOT.jar com.karma.secret.consumer.app.Launcher

#if [[ $output == 'FILE_DOES_NOT_EXIST' ]];then
#  echo 'SECRET_LOADER:'$output
#  exit 1
#fi
#
#if [[ $output == 'FILE_IO_ERROR' ]];then
#  echo 'SECRET_LOADER:'$output
#  exit 1
#fi
#
#if [[ $output == 'KEY_NAME_NOT_FOUND' ]];then
#  echo 'SECRET_LOADER:'$output
#  exit 1
#fi

#export MONGO_USER_NAME=$output
#java -cp /Users/singg/openws/java/sample-secret-consumption-app/target/sample-secret-consumption-app-1.0-SNAPSHOT.jar com.karma.secret.consumer.app.Launcher