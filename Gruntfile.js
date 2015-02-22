module.exports = function (grunt) {
    grunt.initConfig({
        // dist配下のファイルをhttp://localhost:9000/で公開する
        connect: {
            options: {
                port: 9000,
                hostname: 'localhost'
            },
            my_target: {
                options: {
                    base: 'dist'
                }
            }
        },
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
                stdout: true
            },

            // Selenium Serverをバックグラウンドで実行
            selenium: {
                command: "webdriver-manager start",
                options: {
                    stdout: false,
                    async: true
                }
            },

            // Selenium Serverのインストールおよび更新
            protractor_install: {
                command: "webdriver-manager update"
            }
        }
    });
    require('matchdep').filterDev('grunt-*').forEach(grunt.loadNpmTasks);
};