function main() {
    cd ./eureka/; sh ./build.sh; cd ..
    cd ./exercises/; sh ./build.sh; cd ..
    cd ./gateway/; sh ./build.sh; cd ..
    cd ./trainings/; sh ./build.sh; cd ..
}

main "$@"