#! /bin/sh

line() {
  echo "------------------------------------------------------------------------------"
}

message() {
  message=$1
  line
  echo "${message}"
  line
}

build() {
  message "iniciando construção do projeto"

  gradle assemble

  message "construção do projeto finalizada"
}

compose() {
  message "iniciando construção dos containers"

  docker-compose -f docker/docker-compose.yml up --build -d

  message "aplicação iniciada com sucesso"
}

if asdf --version >/dev/null; then
  message "asdf instalado, adicionando plugin gradle"

  asdf plugin-add gradle
  asdf install gradle
else
  message "é necessário instalar o asdf para a construção do projeto"
  exit 1
fi

if asdf current gradle>/dev/null; then
  message "gradle instalado corretamente"

  build
else
  message "falha ao instalar gradle"
  exit 1
fi

if docker --version >/dev/null && docker-compose --version >/dev/null; then
  message "docker e docker-compose instalado"

  compose
else
  message "é necessário instalar o docker e docker compose para a construção do projeto"
  exit 1
fi
