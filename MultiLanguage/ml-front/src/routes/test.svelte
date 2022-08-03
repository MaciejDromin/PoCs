<script lang="ts">
    export let content: string

    async function getLabel() {
        try {
            const url = "/label"
            const response = await fetch(url, {
                method: 'GET'
            })
            return response.json()
        } catch (error) {
            console.log("Something went wront...")
        }
    }

    const labelPromise = getLabel() ?? { content }
</script>

{#await labelPromise}
    <h1>Waiting for data</h1>
{:then data}
    <h1>{data?.content ?? content}</h1>
{:catch}
    <h1>Something went wrong</h1>
{/await}