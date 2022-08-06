<script lang="ts">
    import { supportedLanguages } from "../lib/languages"
    import type { Label } from "../lib/Label"
    let code = ''
    let lang = supportedLanguages.languages[0]
    let content = ''

    async function saveLabel() {
        let body: Label = {
            code: code,
            lang: lang,
            content: content
        }
        try {
            const url = "/api/labels"
            const response = await fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                },
                body: JSON.stringify(body)
            })
            return response.json()
        } catch (error) {
            console.log("Something went wrong...")
        }
    }

</script>

<select bind:value="{lang}">

    {#each supportedLanguages.languages as language}
        <option value={language}>{language}</option>
    {/each}

</select>

<input bind:value={code} placeholder="Input label code">
<input bind:value={content} placeholder="Input label content">

<button on:click="{saveLabel}">Save</button>