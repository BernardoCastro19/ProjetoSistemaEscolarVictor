@echo off
REM Script para mover todos os arquivos da pasta target para outra pasta

REM Caminho da pasta de origem
set "origem=C:\Users\Castro\Desktop\ProjetoSistemaEscolarVictor\2025_2_Aplicacoes_Coorporativas\target\AppCorporativaMavenWeb.war"

REM Caminho da pasta de destino
set "destino=C:\dev\pac2025\apache-tomcat-11.0.11\webapps"

REM Cria a pasta de destino se não existir
if not exist "%destino%" (
    mkdir "%destino%"
)

REM Move todos os arquivos da origem para o destino
move "%origem%" "%destino%"

REM Mensagem de confirmação
if %errorlevel%==0 (
    echo Arquivos movidos com sucesso!
) else (
    echo Nenhum arquivo encontrado ou erro ao mover.
)

pause
