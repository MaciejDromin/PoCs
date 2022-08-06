<script lang="ts">
    import type { Label } from "../lib/Label"
    import en from '$lib/assets/en.png'
    import pl from '$lib/assets/pl.png'
    import Flag from '../components/Flag.svelte'
    import language from "$lib/stores/language"
    export let labels: Label[] = []

    let varsForCode1 = {
        secret: "I have been translated!"
    }

    async function getLabels() {
        try {
            const url = "/api/labels?lang=" + $language
            const response = await fetch(url, {
                method: 'GET'
            })
            return await response.json()
        } catch (error) {
            console.log("Something went wrong...")
        }
    }

    const dLabels = getLabels() ?? { labels }

    const fillVars = (content: string, vars: {} = {}) => {
        (Object.keys(vars) as Array<keyof typeof vars>).map((k) => {
            const regex = new RegExp('{{'+k+'}}', "g")
            content = content.replace(regex, vars[k])
        })

        return content
    }

    const setLang = (code:string) => {
        if ($language === code) return
        language.set(code)
        location.reload()
    }

    const isSelected = (code:string) => {
        return $language === code
    }

    const retrieveLabelContent = async (code:string, variables: {} = {}) => {
        let rLabels:Label[] = await dLabels
        console.log(rLabels)
        for (var ind in rLabels) {
            let lab:Label = rLabels[ind]
            if (lab.code === code) {
                return fillVars(lab.content, variables)
            }
        }
        return "Label with code " + code + " not found"
    }

</script>

<Flag alt="English" src={en} isSelected={isSelected("en")} on:click="{() => setLang("en")}" />
<Flag alt="Polish" src={pl} isSelected={isSelected("pl")} on:click="{() => setLang("pl")}" />

{#await retrieveLabelContent("code1", varsForCode1)}
    <h1>Waiting for data</h1>
{:then data} 
    {data}
{/await}