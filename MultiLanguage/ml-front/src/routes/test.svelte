<script lang="ts">
    type Label = {
        content: string
    }
    export let labels: Label[]

    async function getLabel() {
        try {
            const url = "/labels"
            const response = await fetch(url, {
                method: 'GET'
            })
            return response.json()
        } catch (error) {
            console.log("Something went wrong...")
        }
    }

    const labelPromise = getLabel() ?? { labels }
</script>

{#await labelPromise}
    <h1>Waiting for data</h1>
{:then data}
    {#each data as label}
        <h1>{label.content}</h1>
    {/each}
{:catch}
    <h1>Something went wrong</h1>
{/await}