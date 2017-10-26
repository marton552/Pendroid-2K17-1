all:
	./gradlew desktop:run
build:
	./gradlew build
format:
	find . -name *lint* -print0|xargs -0 rm -rf
	find . -name *.txt -print0|xargs -0 rm -rf
clean:
	rm -rf android/build
