cmake_minimum_required(VERSION 3.4.1)

add_library(MyApp SHARED
            MyApp.c)

# Include libraries needed for MyApp lib
target_link_libraries(MyApp
                      android
                      log)