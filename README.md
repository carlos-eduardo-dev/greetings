# Greetings with Micronaut 3.6.2

Basic service to return hello message, and using nginx as load balancer, redirect requests correctly.

## Testing greetings service

1. grant execute permission to build file and execute
    1. the application jar will be generated
    2. using docker compose, two service containers will be started
    3. nginx will be exposed on port 80

```shell
chmod +x build.sh
sh build.sh
```

2. open your browser of choice at [localhost](http://localhost:80), or use the following curl command to send a request
   to
   this web address

```shell
curl -X GET http://localhost:80
```

### Customizing return message

if you want the service to return the message with a specific name, just add the name after the url like
this: `http://localhost:80/${name}`

```shell
curl -X GET http://localhost:80/carlos
```

## Micronaut 3.6.2 Documentation

- [User Guide](https://docs.micronaut.io/3.6.2/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.6.2/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.6.2/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)

---

- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)

## Feature management documentation

- [Micronaut Management documentation](https://docs.micronaut.io/latest/guide/index.html#management)

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)


