module.exports = function (grunt) {
    grunt.initConfig({
        // test/conf.jsの設定に従ってテストを実行
        protractor: {
            options: {
                keepAlive: true,
                noColor: false
            },
            my_target: {
                options: {
                    configFile: "test/integration/conf.js"
                }
            }
        },
        shell: {
            options: {
                stdout: false
            },
            // Selenium Serverをバックグラウンドで実行
            webdriver_start: {
                command: "webdriver-manager start",
                options: {
                    async: true
                }
            },
            sleep: {
                command: "sleep 5",
                options: {
                    async: false
                }
            },
            // Selenium Serverのインストールおよび更新
            protractor_install: {
                command: "webdriver-manager update"
            },
            webdriver_stop: {
                command: "ps -ef | grep selenium-server-standalone | grep -v grep | awk '{print $2}' | xargs kill -9",
                options: {
                    async: false
                }
            }
        }
    });
    require('matchdep').filterDev('grunt-*').forEach(grunt.loadNpmTasks);
    grunt.registerTask('test', "protractor run" , function(){
        grunt.task.run('shell:webdriver_start','shell:sleep','protractor:my_target','shell:webdriver_stop');
    });
};
