# Cron Expression Parser

This utility operates from the command line and is designed to analyze a given cron string. It expands each field within
the cron string to display the corresponding times at which the command will be executed.

The program strictly adheres to the standard cron format, which consists of five time-related fields (minute, hour, day
of the month, month, and day of the week) along with the associated command. The input is expected to be provided as a
single line, with the cron string being passed as a sole argument to the application.

Here is an example of how to use the program:

```
$ your-program "*/15 0 1,15 * 1-5 /usr/bin/find"
```

## Usage Instructions

To execute the program, follow these steps:

Run the shell script named build_and_run.sh while providing the cron string as an argument, as shown below:

```
$ ./build_and_run.sh "*/15 0 1,15 * 1-5 /usr/bin/find"
```

It compiles the java files to ./src/out directory and runs the main class from there.

The output is formatted as a table with the field name taking the first 14 columns and
the times as a space-separated list following it.

For example, the following input argument:

```./build_and_run.sh "*/15 0 1,15 * 1-5 /usr/bin/find"```

The program will produce the following output:

```
minute        0 15 30 45
hour          0
day of month  1 15
month         1 2 3 4 5 6 7 8 9 10 11 12
day of week   1 2 3 4 5
command       /usr/bin/find
```

## Limitations

The program does not support special time strings such as "@yearly".
It does not account for months with fewer than 31 days.

## Test Suite

A set of tests is included within the test/ directory. While these tests are not exhaustive, they cover various parser
scenarios and ensure the desired output is produced for the given expressions.