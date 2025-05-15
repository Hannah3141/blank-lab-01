#!/bin/bash
# NOTE: Update these variables to target different files with this script. #
MAIN="main.java.Main"
# ======================================================================== #
CP_DELIM=":"
if [[ "$OSTYPE" == "cygwin" || "$OSTYPE" == "msys" || "$OSTYPE" == "win32" ]]; then
    CP_DELIM=";" # changes to ; for Windows
fi
# ======================================================================== #
if [[ $1 == "" || $1 == "build" || $1 == "default" ]]
then
    ./build.sh clean
    javac -d target -cp "lib/*${CP_DELIM}src" src/main/java/*.java
elif [[ $1 == "run" ]]
then
    ./build.sh build && java -cp "lib/*${CP_DELIM}target" $MAIN "${@:2}"
elif [[ $1 == "test" ]]
then
    ./build.sh build
    if [[ $? == 0 ]]; then
        for filename in src/test/java/*.java; do
            javac -d target -cp "lib/*${CP_DELIM}src" $filename
        done
        java -cp "lib/*${CP_DELIM}target" test.java.TUGrader "${@:2}"
    fi
elif [[ $1 == "docs" ]]
then
    javadoc -cp "lib/*${CP_DELIM}src" -d docs src/main/java/*
elif [[ $1 == "fmt" ]]
then
    java -jar lib/google-java-format.jar --replace --skip-javadoc-formatting src/main/java/*.java src/test/java/*.java
elif [[ $1 == "pull" ]]
then
    git stash
    git fetch origin main
    git pull origin main
    git stash pop
elif [[ $1 == "sync" ]]
then
    git add -A
    git commit -m "Syncs changes"
    git fetch origin main
    git pull origin main
    git push origin main
elif [[ $1 == "submit" ]]
then
    ./build.sh fmt
    ./build.sh test
    if [[ $1 == 0 ]]; then
        git add -A
        git commit -m "Submits assignment"
        git fetch origin main
        git pull origin main
        git push origin main
    fi
elif [[ $1 == "init" ]]
then
    rm -r config
    rm .grader.conf
    echo "all" > .grader.conf
    rm src/test/java/FailingTest.java
    rm src/test/java/PassingTest.java
    rm src/test/java/TUGraderTest.java
    sed -i ".sh" "s/MAIN=\"test\.java\.TUGrader\"/MAIN=\"$2\"/" "build.sh"
    rm build.sh
elif [[ $1 == "clean" ]]
then
    if [[ -n $(find target -name '*.class') ]]; then
        rm -r target/*
    fi
else
    echo "build: *** No rule to make target '$1'.  Stop."
fi
